package com.prudential.core.common.configuration.camelconfiguration;

import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.prudential.core.common.configuration.excel.bank.BankFeedConfigurator;
import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIInputFeedAggregator;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;

public class CBISourceInRouteBuilder extends RouteBuilder {

	private String systemName;
	private String category;
	private String paymentType;
	private String sourceFeedPolling;
	private InputStream is;
	private String rootPath;
	private FileAuditDAO auditDao;
	private CBIConfigService configService;
	
	private String directEndPoint;

	private static final Logger logger = LoggerFactory.getLogger(CBISourceInRouteBuilder.class);

	public CBISourceInRouteBuilder(String systemName, String category, String paymentType, String sourceFeedPolling,
			InputStream is, String rootPath, FileAuditDAO auditDao , CBIConfigService configService) {
		super();
		this.systemName = systemName;
		this.category = category;
		this.paymentType = paymentType;
		this.sourceFeedPolling = sourceFeedPolling;
		this.is = is;
		this.rootPath = rootPath;
		this.auditDao = auditDao;
		this.configService = configService;
		directEndPoint = "direct:Out"+systemName;
	}

	@Override
	public void configure() throws Exception {

		BankFeedConfigurator configurator = BankFeedConfigurator.from(is);

		configurator.initSource(systemName, null, null);

		CBIGenerateAuditRecord auditProcessor = new CBIGenerateAuditRecord(category, systemName, paymentType, auditDao,
				"Inward", BankTxnRecord.State.SOURCE_FEED_RECIEVED.toString());
		
		CBIUpdateAuditAndTxnStatus updateProcessor = new CBIUpdateAuditAndTxnStatus(category, systemName, paymentType, auditDao,
				"Inward", BankTxnRecord.State.SOURCE_FEED_PROCESSED.toString(),configService);

		CBISourceInFeedProcessor processor = new CBISourceInFeedProcessor(configurator,systemName, category, paymentType,configService);

		try {

			
			 onException(Exception.class)
			 .handled(true)
		        .process(auditProcessor)
		        .log("Moved file ${file:name} to Exception Folder");
			
			
			
			// file endPoint to Listen to Folder
			from(CBIRouteUtils.getFileRouteID(rootPath, systemName, sourceFeedPolling) + "&doneFileName=" + systemName
					+ ".done")
				.routeId(systemName)
				.choice().when(body().isNotNull()).to(directEndPoint).otherwise().end();
					
			
			
					from(directEndPoint)
							// suspend the File Transfer Route
							.to("controlbus:route?routeId=" + systemName + "Transfer" + "&action=suspend")
							.process(auditProcessor)
							// Split the File in to the single records
							.split(body().tokenize("\r\n")).streaming()
							// Aggreagate the records in size of 1000
							.aggregate(header(Exchange.FILE_NAME), new CBIInputFeedAggregator()).completionSize(1000)
							// Aggregation backUp strategy in case records doesn't reach size with given
							// time
							.completionTimeout(3500)
							// Do processing to convert records
							.process(processor)
							// persist the batch of records
							
							.to(directEndPoint+"1");
					
			
							from(directEndPoint+"1")
							.to("jpa://com.prudential.core.cbi.model.BankTxnRecord?entityType=java.util.List")
							.process(updateProcessor)

							// Start the File Transfer Route when file processing is completed
							.choice().when(header("FileProcessingCompleted").isEqualTo(true))
							.to("controlbus:route?routeId=" + systemName + "Transfer" + "&action=resume")
							.end();

	
		
		} catch (Throwable e) {
			logger.error(e.getMessage());
		}
	}

}
