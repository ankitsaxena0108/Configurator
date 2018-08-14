package com.prudential.core.common.configuration.camelconfiguration.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class CBIInputFeedAggregator implements AggregationStrategy {
	
	public CBIInputFeedAggregator() {
		super();
	}
 
	
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        List<String> list = null;
        if(oldExchange == null || oldExchange.getIn() == null)
        {
            list = new ArrayList<String>();
            list.add(newExchange.getIn().getBody(String.class));
        }
        else
        {
            list = oldExchange.getIn().getBody(List.class);
            list.add(newExchange.getIn().getBody(String.class));
        }
        newExchange.getIn().setBody(list);
        return newExchange;
    }}
 
