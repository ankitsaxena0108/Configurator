package com.prudential.core.common.configuration.camelconfiguration;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.configurations.BankConfig;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIInputFeedAggregator;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIOutFeedAggregator;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;

public class CBIBankOutRouteBuilder extends RouteBuilder{
	

	
	private String systemName;
	private String rootPath;
	private String category=null;
	private String paymentType=null;
	private String cronConfig;
	private int batchSize;
	private String state;
	private FileAuditDAO auditDao;
	private CBIConfigService configService;
	private String directEndPoint = "";

	
	
	
	public CBIBankOutRouteBuilder(int batchSize,BankConfig bankConfig,
			String state, String rootPath,CBIConfigService configService,FileAuditDAO auditDao) {
		
		super();
	
		this.systemName = bankConfig.getBankCode();
		this.rootPath = rootPath;
		this.category = bankConfig.getCategory();
		this.paymentType = bankConfig.getPaymentType();
		this.cronConfig=bankConfig.getCronConfig();
		this.batchSize = batchSize;
		this.configService = configService;
		this.state = state;
		this.auditDao=auditDao;
		
		directEndPoint = "direct:"+systemName;
		
		
	}

	
	private static final Logger logger = LoggerFactory.getLogger(CBIBankOutRouteBuilder.class);
	

	@Override
	public void configure() throws Exception
	{
		
		
		CBIBankOutFeedProcessor processor = new CBIBankOutFeedProcessor();
		CBIReadBankOutRecords readProcessor = new CBIReadBankOutRecords(configService, systemName, category, paymentType,state,batchSize);
		CBIUpdateRecordStateProcessor updateProcessor = new CBIUpdateRecordStateProcessor(configService);
		CBIFetchBankFileNameProcessor bankFileProcessor = new CBIFetchBankFileNameProcessor(configService,systemName,category,paymentType,state,systemName);
		
		
		CBIGenerateAuditRecord auditProcessor = new CBIGenerateAuditRecord(category, systemName, paymentType, auditDao,
				"Outward", BankTxnRecord.State.BANK_FEED_CREATED.toString());
		
		 onException(Exception.class)
		 .handled(true)
	      .log("Processing Failed while Creating Bank Request");
		
		
		from("quartz2://"+systemName+"?cron="+cronConfig).routeId(systemName+"Out")
		.to(directEndPoint+"0");
		
		from(directEndPoint+"0")
		.process(bankFileProcessor)
		.choice()
		.when(body().isNotNull())
		.to(directEndPoint+"1")
		.otherwise()
		.end();
		
		
		from(directEndPoint+"1")
		//split the body per File name and send for Processing
		.split(body())
		.process(readProcessor)
		.to(directEndPoint+"2");
		  
		
		  
		from(directEndPoint+"2")
		  .process(processor)
		  .split(body()).transform(body().append("\r\n"))
		  // Aggreagate the records in size of 1000
		  .aggregate(header(Exchange.FILE_NAME), new CBIOutFeedAggregator()).completionSize(100)		
			// Aggregation backUp strategy in case records doesn't reach size with given
			// time
		  .completionTimeout(3500)
		  .to(CBIRouteUtils.getFileRouteID(rootPath,systemName,null))
		  .process(updateProcessor)
		  .process(auditProcessor)
		  .end();
		
		
	}


}
