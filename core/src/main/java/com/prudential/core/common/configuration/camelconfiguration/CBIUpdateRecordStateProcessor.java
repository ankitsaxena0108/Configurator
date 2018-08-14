package com.prudential.core.common.configuration.camelconfiguration;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prudential.core.cbi.services.CBIConfigService;
import com.prudential.core.common.configuration.camelconfiguration.helper.CBIRouteUtils;

public class CBIUpdateRecordStateProcessor implements Processor {
	
	private CBIConfigService config;
	
	private static final Logger logger = LoggerFactory.getLogger(CBIUpdateRecordStateProcessor.class);

	
	
	
	public CBIUpdateRecordStateProcessor(CBIConfigService config) {
		super();
		this.config = config;
	}




	@Override
	public void process(Exchange exchange) throws Exception {

		try {
		
		String state = (String) exchange.getIn().getHeader("CURRENT_STATE");

		List<String> ids = (List<String>) exchange.getIn().getHeader("ID_TO_BE_CHANGED");

		String nextState = CBIRouteUtils.getNextState(state);

		List<String> idTobeUpdated = new ArrayList<String>();
		List<List<String>> totalIds = new ArrayList<>();
		int count = 0;

		// do commit in batches of 950

		for (String id : ids) {

			idTobeUpdated.add(id);

			if (++count % 950 == 0) {
				totalIds.add(idTobeUpdated);
				idTobeUpdated = new ArrayList<String>();
			}

		}

		totalIds.add(idTobeUpdated);
		
		for (List<String> list : totalIds) {

			config.updateBankTxnRecordStatus(list, nextState);

		}
		
		
		
		
		

	}
	catch(Exception e)
	{
		
		logger.error("Processing Failed while updating bank request "+e.getMessage());
		
		exchange.getOut().setHeader("Exception", true);
		
	}
	
	
	}

}
