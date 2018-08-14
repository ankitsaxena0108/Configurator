package com.prudential.core.common.configuration.camelconfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIConstants;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.configuration.excel.Response;
import com.prudential.core.common.configuration.excel.Response.Output;
import com.prudential.core.common.configuration.excel.bank.BankFeedConfigurator;

public class CBIBankInFeedProcessor implements Processor {

	private static final Logger logger = LoggerFactory.getLogger(CBIBankOutFeedProcessor.class);

	@Autowired
	EntityManager em;

	private BankFeedConfigurator configurator;

	private CBIConfigService configService;

	private String systemName;

	private Integer batchSizeCount = 0;

	public CBIBankInFeedProcessor(BankFeedConfigurator configurator, CBIConfigService configService,
			String systemName) {
		super();
		this.configurator = configurator;
		this.configService = configService;
		this.systemName = systemName;
	}

	@Override
	public void process(Exchange exchange) throws Exception {

		boolean isBiroOrEbanking = false;

		if (systemName.toUpperCase().contains("BIRO") || systemName.toUpperCase().contains("EBANK")) {
			isBiroOrEbanking = true;
		}

		logger.info("Doing Bank Response Processing Now " + exchange.getIn().getBody(ArrayList.class));

		try {

			String responsefileName = (String) exchange.getIn().getHeader("CamelFileNameOnly");
			List<String> message = exchange.getIn().getBody(ArrayList.class);

			int batchSize = (int) exchange.getProperty("CamelBatchSize");
			Boolean splitComplete = (Boolean) exchange.getProperty("CamelSplitComplete");
			int lineNumber = (int) exchange.getProperty("CamelSplitIndex");

			lineNumber++;

			Response response;
			int batchNumber = 0;

			List<BankTxnRecord> records = new ArrayList<>();
			BankTxnRecord value = null;

			for (String body : message) {

				response = configurator.process(body);
				if (response == null)
					continue;
				Output output = response.getOutput();

				value = null;

				// if There is error in Header and Footer Validation then File Will be Marked as
				// Failed

				if ((response.isFooter() || response.isHeader()) && !response.isValid()) {

					records.clear();
					exchange.setProperty("auditFailureStatus", "FAILED");
					logger.error("File " + responsefileName + " for Bank " + systemName
							+ " failed Header/Footer Validation");

					break;
				}

				// if there is error in particular record in File then Log and Skip that record
				// and continue with others

				if (response.isDetail() && !response.isValid()) {
					logger.error("Line Number " + lineNumber + "from File " + responsefileName + " for Bank "
							+ systemName + " is not Valid");

					// To Do
					// Update the record in Audit Detail Table
					continue;
				}

				// If Response is not Header and Footer then Update the Record or Create new one
				// based on condition

				if (response.isHeader() == false && response.isFooter() == false) {
					value = new BankTxnRecord();
					if (isBiroOrEbanking) {

						Map<String, String> paymentType = CBIRouteUtils.getCategoryAndPaymentType(systemName);
						value = CBIRouteUtils.getBankTxnRecord(paymentType.get(CBIConstants.CATEGORY_KEY),
								paymentType.get(CBIConstants.PAYMENT_MODE_KEY),
								BankTxnRecord.State.BANK_RESP_PROCESSED.toString(), response, value, output, body,
								responsefileName, exchange);

					}

					else {
						if (!(output.getDetailRow() == null || output.getDetailRow().equals("null"))) {
							value.setSourceDetailRecord(output.getDetailRow());

							value.setBankResRecvDate(exchange.getProperty(Exchange.CREATED_TIMESTAMP, Date.class));
							value.setPolicyNo(String.valueOf(response.getComputedValues().get("PolicyNo")));
							value.setResponseCode(String.valueOf(response.getComputedValues().get("BankRespCode")));
						} else {
							value = null;
						}
					}

				}

				if (value != null)
					records.add(value);

			}

			if (!records.isEmpty() && !isBiroOrEbanking) {
				batchNumber = configService.findAndUpdateBankRecords(records, responsefileName,
						BankTxnRecord.State.BANK_FEED_CREATED.toString(), systemName);
			}

			// When File Processing Completed Set header to true
			// For Empty Files for now it is updating based on the FileName and bankname and
			// State

			if (splitComplete) {

				if (!isBiroOrEbanking) {

					if (message == null || message.isEmpty()) {

						// Code to Handle Empty Files
						configService.updateBankTxnRecordByFileNameAndState(responsefileName,
								BankTxnRecord.State.BANK_FEED_CREATED.toString(), systemName);

					}

					else {

						configService.updateBankTxnRecordByBatchNumberAndState(batchNumber,
								BankTxnRecord.State.BANK_RES_RECEIVED.toString(),
								BankTxnRecord.State.BANK_FEED_CREATED.toString(), systemName);

					}

				}

				else {
					configService.batchInsertBankTxnRecord(records);
				}

				synchronized (batchSizeCount) {
					batchSizeCount++;
					if (batchSizeCount == batchSize) {
						batchSizeCount = 0;
						exchange.getOut().setHeader("FileProcessingCompleted", true);
						configurator.processFinal();
						// initializing the configurator again for processing
						configurator.initBank(systemName, null, null);

					}
				}

			}

		} catch (Exception e) {

			logger.error("Processing Failed For Bank Response File"
					+ (String) exchange.getIn().getHeader("CamelFileNameOnly") + " processing with error "
					+ e.getMessage());

			exchange.getOut().setHeader("Exception", true);

		}
	}
}