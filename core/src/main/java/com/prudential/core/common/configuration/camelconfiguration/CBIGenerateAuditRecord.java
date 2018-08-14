package com.prudential.core.common.configuration.camelconfiguration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.model.FileAudit;

public class CBIGenerateAuditRecord implements Processor {

	private String category;

	private String systemName;

	private String paymentType;

	private String direction;

	private String status;

	private FileAuditDAO auditDao;

	public CBIGenerateAuditRecord(String category, String systemName, String paymentType, FileAuditDAO auditDao,
			String direction, String status) {
		super();
		this.category = category;
		this.systemName = systemName;
		this.paymentType = paymentType;
		this.auditDao = auditDao;
		this.direction = direction;
		this.status = status;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		
		Long id = (Long)exchange.getProperty("auditId");
		
		exchange.setProperty("FileAuditDaoObj", auditDao);
		
		if(id==null)
		{
		String fileName;
	
			if (direction.equals("Inward"))

				fileName = (String) exchange.getIn().getHeader("CamelFileNameOnly");
			else
				fileName = (String) exchange.getIn().getHeader(Exchange.FILE_NAME);
		
		FileAudit auditRecord = new FileAudit();
		auditRecord.setSystemId(systemName);
		auditRecord.setStartDateTime(
				new Timestamp(exchange.getProperty(Exchange.CREATED_TIMESTAMP, Date.class).getTime()));
		auditRecord.setFileCategory(category);
		auditRecord.setPaymentType(paymentType);
		auditRecord.setFileDirection(direction);
		auditRecord.setFileStatus(status);
		auditRecord.setFileName(fileName);
		auditRecord = auditDao.createFileAudit(auditRecord);
		exchange.setProperty("auditId", auditRecord.getId());
		
		
		}
		
		else
		{
			auditDao.updateStatusById(id, "FAILED");
		}
	}

}
