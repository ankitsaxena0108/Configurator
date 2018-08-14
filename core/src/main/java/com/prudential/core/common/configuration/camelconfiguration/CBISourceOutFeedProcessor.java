package com.prudential.core.common.configuration.camelconfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prudential.core.cbi.model.BankTxnRecord;
import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.excel.bank.SourceSheet;

public class CBISourceOutFeedProcessor implements Processor{
	
	
	private CBIConfigService config;
	private String systemName;
	private String category;
	private String paymentType;
	private String state = "BANK_RESP_PROCESSED";
	
	private static final Logger logger = LoggerFactory.getLogger(CBISourceOutFeedProcessor.class);

	
	public CBISourceOutFeedProcessor(CBIConfigService config, String systemName, String category, String paymentType) {
		super();
		this.config = config;
		this.systemName = systemName;
		this.category = category;
		this.paymentType = paymentType;
	}


	@Override
	public void process(Exchange exchange) throws Exception {

		Map<String,List<BankTxnRecord>> result = config.fetchSourceResponsePerBank(systemName, category, paymentType);
		
		List<List<BankTxnRecord>> records = new ArrayList<List<BankTxnRecord>>();
		
		for(Map.Entry<String,List<BankTxnRecord>> entry : result.entrySet())
		{
			records.add(entry.getValue());
		}
		exchange.getOut().setBody(records);
		
		
	}

}
