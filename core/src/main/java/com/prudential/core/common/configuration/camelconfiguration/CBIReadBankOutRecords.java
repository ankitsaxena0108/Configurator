package com.prudential.core.common.configuration.camelconfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;
import com.prudential.core.common.configuration.excel.bank.SourceSheet;

public class CBIReadBankOutRecords implements Processor {

	private CBIConfigService config;
	private String bankCode;
	private String category;
	private String paymentType;
	private int noOfRecords;
	private String state;

	public CBIReadBankOutRecords(CBIConfigService config, String bankCode, String category, String paymentType,
			String state, int noOfRecords) {
		super();
		this.config = config;
		this.bankCode = bankCode;
		this.category = category;
		this.paymentType = paymentType;
		this.noOfRecords = noOfRecords;
		this.state = state;
	}

	private static final Logger logger = LoggerFactory.getLogger(CBIReadBankOutRecords.class);

	@Override
	@Transactional
	public void process(Exchange exchange) throws Exception {

		//Read All the Records group by File name
		try {
		List<String> ids = new ArrayList<String>();
		
		List<Long> tempId ;
		
		List<List<String>> toBeUpdated = new ArrayList<List<String>>();
		
		String fileName = exchange.getIn().getBody(String.class);
		
		List<BankTxnRecord> records = config.findBankOutFeedRecords(bankCode, category, paymentType, state,
				fileName);
		
		int count =0;

		for (BankTxnRecord txnRecord : records) {
			
				// Update the Status of the Record to FEED_INPROGRESS
				ids.add(txnRecord.getId());
			
				if(++count%950 == 0)
				{
					toBeUpdated.add(ids);
					ids = new ArrayList<String>();
				}
				
		
		}
		
		toBeUpdated.add(ids);
		
		String nextState= CBIRouteUtils.getNextState(state);
		
	
		for (List<String> updateIds: toBeUpdated) {
			
			config.updateBankTxnRecordStatus(updateIds, nextState);
		}
		
	
		exchange.getOut().setBody(records);

	}

		catch(Exception e)
		{
			logger.error("Processing Failed while reading bank response "+e.getMessage());
			
			exchange.getOut().setHeader("Exception", true);
		}
		
	}
	
}