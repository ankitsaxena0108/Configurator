package com.prudential.core.common.configuration.camelconfiguration.helper;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;


public class CBIOutFeedAggregator implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

		if (oldExchange == null) {
			return newExchange;
		}

		String oldBody = oldExchange.getIn().getBody(String.class);
		String newBody = newExchange.getIn().getBody(String.class);
		String body = oldBody + newBody;

		oldExchange.getIn().setBody(body);

		return oldExchange;
	}
}