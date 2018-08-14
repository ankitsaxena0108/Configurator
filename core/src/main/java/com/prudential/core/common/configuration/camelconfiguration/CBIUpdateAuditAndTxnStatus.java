package com.prudential.core.common.configuration.camelconfiguration;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.model.FileAudit;
import com.prudential.core.cbi.services.CBIConfigService;

public class CBIUpdateAuditAndTxnStatus implements Processor {

	private String category;

	private String systemName;

	private String paymentType;

	private String direction;

	private String status;

	private FileAuditDAO auditDao;

	private CBIConfigService configService;

	public CBIUpdateAuditAndTxnStatus(String category, String systemName, String paymentType, FileAuditDAO auditDao,
			String direction, String status, CBIConfigService configService) {
		super();
		this.category = category;
		this.systemName = systemName;
		this.paymentType = paymentType;
		this.auditDao = auditDao;
		this.direction = direction;
		this.status = status;
		this.configService = configService;
	}

	@Override
	public void process(Exchange exchange) throws Exception {

		Boolean splitComplete = false;
		Boolean isBiroOrEbanking= false;
		

		if (exchange.getProperty("CamelSplitComplete") != null)
			splitComplete = (Boolean) exchange.getProperty("CamelSplitComplete");

		if (splitComplete) {

			Long id = (Long) exchange.getProperty("auditId");
			
			//If Status is failure then mark File as Failed
			if(exchange.getProperty("auditFailureStatus")!=null)
			{
				status= (String) exchange.getProperty("auditFailureStatus");
			}
			
			//To DO change method to take Audit Object and Update the totals in Audit
			auditDao.updateStatusById(id, status);
			

			if(status.contains("SOURCE"))
			configService.updateBankTxnRecordByAuditId(id, status);

		}

	}

}
