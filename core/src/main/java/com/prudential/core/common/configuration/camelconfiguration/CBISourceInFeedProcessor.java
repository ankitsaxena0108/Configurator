package com.prudential.core.common.configuration.camelconfiguration;


import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyUtils;

import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIConstants;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.configuration.excel.Response;
import com.prudential.core.common.configuration.excel.Response.Output;
import com.prudential.core.common.configuration.excel.bank.BankFeedConfigurator;


	public class CBISourceInFeedProcessor implements Processor {
		
		private static final Logger logger = LoggerFactory.getLogger(CBISourceInFeedProcessor.class);

		private BankFeedConfigurator configurator;
		
		private String category;
		
		private String paymentType;
		
		private String systemName;
		
		
		private CBIConfigService configService;
		
		private Integer batchSizeCount=0;
		
		
		public CBISourceInFeedProcessor(BankFeedConfigurator configurator,String systemName,String category,String paymentType , CBIConfigService configService) {
			super();
			this.configurator = configurator;
			this.category=category;
			this.paymentType=paymentType;
			this.configService =  configService;
			this.systemName = systemName;
		}




		@SuppressWarnings("unchecked")
		public void process(Exchange exchange) throws Exception {
			
			
			logger.info("Doing Exchnage Now " + exchange.getIn().getBody(ArrayList.class));
			
			List <String>message = exchange.getIn().getBody(ArrayList.class);
			List<BankTxnRecord> records = new ArrayList<BankTxnRecord>();
			Response response;
			
			FileAuditDAO auditDao=(FileAuditDAO) exchange.getProperty("FileAuditDaoObj");
			
			Long auditId = (Long)exchange.getProperty("auditId");
			
			int batchSize = (int) exchange.getProperty("CamelBatchSize");
			
			String sourceFileName=(String) exchange.getIn().getHeader("CamelFileNameOnly");

			
			Boolean splitComplete = (Boolean)exchange.getProperty("CamelSplitComplete");
			int splitIndex = (int) exchange.getProperty("CamelSplitIndex");
			
			
		//Process each file line and convert in bank format
			
		for (String body : message) {

			try {
				response = configurator.process(body);

				if (response.isValid()) {
					BankTxnRecord record = new BankTxnRecord();
					Output output = response.getOutput();

					if (output.getHeaderRow() != null || output.getDetailRow() != null
							|| output.getFooterRow() != null) {
						records.add(CBIRouteUtils.getBankTxnRecord(category, paymentType,
								BankTxnRecord.State.SOURCE_FEED_RECIEVED.toString(), response, record, output, body,
								sourceFileName, exchange));
					}

				}

				else {

					// in case of invalid Response Creating Audit Detail
					
					CBIRouteUtils.createAuditDetail(auditId,++splitIndex,auditDao,"INVALID_LINE");
					
				}

			} catch (Exception e) {
				
				// in case of invalid Response Creating Audit Detail and continue processing for other lines
				
				CBIRouteUtils.createAuditDetail(auditId,++splitIndex,auditDao,e.getMessage());
				

			}

		}
			
			
			
			exchange.getOut().setHeader("FileProcessingCompleted",false);
			
			List<Response> finalResponse = null;
			
			//check if Split is completed for the exchange if yes update the batchSize count by one
			
			if(splitComplete)
			{
				synchronized (batchSizeCount) {
				batchSizeCount++;
				  if (batchSizeCount == batchSize) {
					   batchSizeCount = 0;
						
						exchange.getOut().setHeader("FileProcessingCompleted",true);
						
						finalResponse = configurator.processFinal();
						
						
						configurator.initSource(systemName, null, null);
					
						//all the files have completed Processing call process Final to genrerate header footer
						
						for(Response value:finalResponse)
						{
							Output output =value.getOutput();
							BankTxnRecord record = new BankTxnRecord();				
							//code to put source Body in here
							records.add(CBIRouteUtils.getBankTxnRecord( category,paymentType,BankTxnRecord.State.SOURCE_FEED_RECIEVED.toString()
									,value, record, output,null,sourceFileName,exchange));

						}
					
					}

				}
				
			}
				
			exchange.getOut().setBody(records);
			
		}
	
		

		public int getBatchSizeCount() {
			return batchSizeCount;
		}




		public void setBatchSizeCount(int batchSizeCount) {
			this.batchSizeCount = batchSizeCount;
		}

}
