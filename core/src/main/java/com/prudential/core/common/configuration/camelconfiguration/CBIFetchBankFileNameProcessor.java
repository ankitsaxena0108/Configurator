package com.prudential.core.common.configuration.camelconfiguration;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.properties.RouteConfigProperties;

public class CBIFetchBankFileNameProcessor implements Processor {

	private CBIConfigService config;
	private String bankCode;
	private String category;
	private String paymentType;
	private String state;
	private String systemName;

	private static final Logger logger = LoggerFactory.getLogger(CBIFetchBankFileNameProcessor.class);
	private RouteConfigProperties properties = new RouteConfigProperties();

	public CBIFetchBankFileNameProcessor(CBIConfigService config, String bankCode, String category, String paymentType,
			String state, String systemName) {
		super();
		this.config = config;
		this.bankCode = bankCode;
		this.category = category;
		this.paymentType = paymentType;
		this.state = state;
		this.systemName = systemName;
	}

	@Override
	public void process(Exchange exchange) throws Exception {

		// set the distinct Name of files for bank to be submitted

		try {

			List<String> records = config.getDistinctBankFileNames(bankCode, category, paymentType, state);
			if (records != null && records.size() > 0) {
				CBIRouteUtils.backupFiles(properties.get("bank.outward.root") + systemName + "/");
			}
			exchange.getOut().setBody(records);

		} catch (Exception e) {
			logger.error("Error While Fetching File Names :" + e.getMessage());
		}

	}

}
