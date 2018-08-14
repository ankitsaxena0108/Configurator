package com.prudential.core.common.configuration.camelconfiguration;

import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIInputFeedAggregator;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.configuration.excel.bank.BankFeedConfigurator;

public class CBIBankInRouteBuilder extends RouteBuilder{
	
	private String systemName;
	private String category;
	private String paymentType;
	private String bankFeedPolling;
	private InputStream is;
	private String rootPath;
	private CBIConfigService configService;
	private FileAuditDAO auditDao;

	
	private static final Logger logger = LoggerFactory.getLogger(CBISourceInRouteBuilder.class);
	
	
	


	public CBIBankInRouteBuilder(String systemName, String category, String paymentType, String feedPolling,
			InputStream is, String rootPath,CBIConfigService configService,FileAuditDAO auditDao) {
	super();
	this.systemName = systemName;
	this.category = category;
	this.paymentType=paymentType;
	this.bankFeedPolling = feedPolling;
	this.is = is;
	this.rootPath = rootPath;
	this.configService=configService;
	this.auditDao = auditDao;
}

	
	
	
    @Override
    public void configure() throws Exception {
    	

    	BankFeedConfigurator configurator = BankFeedConfigurator.from(is);
 
    	configurator.initBank(systemName,null,null);

    	CBIBankInFeedProcessor processor = new CBIBankInFeedProcessor(configurator,configService,systemName);
    	
    	CBIGenerateAuditRecord auditProcessor = new CBIGenerateAuditRecord(category, systemName, paymentType, auditDao,
				"Inward",BankTxnRecord.State.BANK_RES_RECEIVED.toString());
		
		CBIUpdateAuditAndTxnStatus updateProcessor = new CBIUpdateAuditAndTxnStatus(category, systemName, paymentType, auditDao,
				"Inward", BankTxnRecord.State.BANK_RESP_PROCESSED.toString(),configService);
    	
     try {
    	 
    	 onException(Exception.class)
		 .handled(true)
	        .process(auditProcessor)
	        .log("Moved file ${file:name} to Exception Folder");
    	 
    	 //file endPoint to Listen to Folder
    	from(CBIRouteUtils.getFileRouteID(rootPath,systemName,bankFeedPolling) + "&doneFileName=" + systemName
				+ ".done").routeId(systemName)
    	
    	//suspend the File Transfer Route
		.to("controlbus:route?routeId="+systemName+"Transfer"+"&action=suspend")
		.process(auditProcessor)
    	
    	//Split the File in to the single records
    	 .split(body().tokenize("\r\n")).streaming()
    	
    	//Aggreagate the records in size of 1000 
    	 .aggregate(header(Exchange.FILE_NAME),
 				new CBIInputFeedAggregator()).completionSize(1000)
 	   
    	 //Aggregation backUp strategy in case records doesn't reach 100 with given time
    	 .completionTimeout(3500)
    	
    	//Do processing to convert records and persist in DB
    	 .process(processor)
    	 
    	 .process(updateProcessor)
    	
    	 //Start the File Transfer Route and Suspend the current Route when file processing is completed
    	.choice()
		.when(header("FileProcessingCompleted").isEqualTo("true"))
		.to("controlbus:route?routeId=" + systemName + "Transfer" + "&action=resume")
		.end();

    	
    }catch(Throwable e) {
    	logger.info(e.getMessage());
    }
    }
    


}
