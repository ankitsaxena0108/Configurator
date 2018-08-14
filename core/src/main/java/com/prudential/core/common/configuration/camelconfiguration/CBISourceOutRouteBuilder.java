package com.prudential.core.common.configuration.camelconfiguration;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import com.prudential.cbi.dao.FileAuditDAO;
import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIOutFeedAggregator;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;

public class CBISourceOutRouteBuilder extends RouteBuilder {

	private String systemName;
	private String rootPath;
	private String category = null;
	private String paymentType = null;
	private String cronConfig;
	private String state = "BANK_RESP_PROCESSED";
	private CBIConfigService configService;
	private String directEndPoint = "";
	private FileAuditDAO auditDao;

	public CBISourceOutRouteBuilder(String systemName, String rootPath, String category, String paymentType,
			String cronConfig, CBIConfigService configService, FileAuditDAO auditDao) {
		super();
		this.systemName = systemName;
		this.rootPath = rootPath;
		this.category = category;
		this.paymentType = paymentType;
		this.cronConfig = cronConfig;
		this.configService = configService;
		this.auditDao = auditDao;
		directEndPoint = "direct:" + systemName;
	}

	@Override
	public void configure() throws Exception {

		CBISourceOutFeedProcessor sourceFileProcessor = new CBISourceOutFeedProcessor(configService, systemName,
				category, paymentType);

		CBISourceOutFileName sourceFileName = new CBISourceOutFileName(systemName);

		CBIGenerateAuditRecord auditProcessor = new CBIGenerateAuditRecord(category, systemName, paymentType, auditDao,
				"Outward", BankTxnRecord.State.PROCESSED.toString());

		from("quartz2://" + systemName + "?cron=" + cronConfig).routeId(systemName + "Out").to(directEndPoint + "0");

		from(directEndPoint + "0").process(sourceFileProcessor).choice().when(body().isNotNull())
				.to(directEndPoint + "1").otherwise().end();

		from(directEndPoint + "1")
				// split the body per File name and send for Processing
				.split(body()).to(directEndPoint + "2");

		from(directEndPoint + "2").process(sourceFileName).split(body()).transform(body().append("\r\n"))

				// Aggregate the records in size of 1000
				.aggregate(header(Exchange.FILE_NAME), new CBIOutFeedAggregator()).completionSize(999)

				// Aggregation backUp strategy in case records doesn't reach size with given
				// time

				.completionTimeout(3500)

				.to(CBIRouteUtils.getFileRouteID(rootPath, systemName, null)).process(auditProcessor).end();

	}

}
