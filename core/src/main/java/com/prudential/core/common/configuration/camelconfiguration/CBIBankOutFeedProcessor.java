
package com.prudential.core.common.configuration.camelconfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;

public class CBIBankOutFeedProcessor implements Processor {

	private static final Logger logger = LoggerFactory.getLogger(CBIBankOutFeedProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {

		logger.info("Doing Exchnage Now " + exchange.getIn().getBody());

		try {
			List<BankTxnRecord> bankRecords = exchange.getIn().getBody(List.class);

			List<String> body = new ArrayList<String>();
			List<String> updateIdHeader = new ArrayList<String>();

			String header = null;
			String footer = null;
			String state = null;
			String fileName = "";

			for (BankTxnRecord value : bankRecords) {

				if (value.getBankHeaderRecord() != null) {
					header = value.getBankHeaderRecord();
				}

				if (value.getBankDetailRecord() != null) {
					// deCrypt the data of the detail record
					body.add(CBIRouteUtils.encryptDecryptValues(value.getBankDetailRecord(), false));
				}

				if (value.getBankFooterRecord() != null)
					footer = value.getBankFooterRecord();

				if (value.getBankRequestFilename() != null)
					fileName = value.getBankRequestFilename();

				updateIdHeader.add(value.getId());

				state = value.getState();

			}

			/* Header and Footer handled here */

			List<String> result = new ArrayList<String>();

			if (header != null)
				result.add(header);

			result.addAll(body);

			if (footer != null)
				result.add(footer);

			exchange.getOut().setBody(result);

			/*
			 * Code need to Come Here to Put DateTime in FileName Change in configurator
			 * required to put DDMMYY in place of FileName instead of Date
			 */

			exchange.getOut().setHeader(Exchange.FILE_NAME, fileName);
			exchange.getOut().setHeader("ID_TO_BE_CHANGED", updateIdHeader);
			exchange.getOut().setHeader("CURRENT_STATE", CBIRouteUtils.getNextState(state));

		} catch (Exception e) {
			logger.error("Processing Failed For Bank Out File processing with error " + e.getMessage());

			exchange.getOut().setHeader("Exception", true);
		}
	}

}
