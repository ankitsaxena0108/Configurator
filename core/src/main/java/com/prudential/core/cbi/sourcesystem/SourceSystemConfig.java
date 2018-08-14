package com.prudential.core.cbi.sourcesystem;

import java.util.Map;


public class SourceSystemConfig {
	
	String sourceSystemName;
	String cronConfig;
	String category;
	String paymentType;
	String pollingInterval;
	
	public String getPollingInterval() {
		return pollingInterval;
	}


	public void setPollingInterval(String pollingInterval) {
		this.pollingInterval = pollingInterval;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	Map<String,Object> additionalAttributes;



	//Source In Config Feed Wise
	Map<String,SourceInputFeedConfig> sourceInputFeedConfig;
	
	
	//Source Out Config Category Wise
	Map<String,SourceOutFeedConfig> sourceOutFeedConfig;


	public String getSourceSystemName() {
		return sourceSystemName;
	}


	public void setSourceSystemName(String sourceSystemName) {
		this.sourceSystemName = sourceSystemName;
	}


	public String getCronConfig() {
		return cronConfig;
	}


	public void setCronConfig(String cronConfig) {
		this.cronConfig = cronConfig;
	}


	public Map<String, SourceInputFeedConfig> getSourceInputFeedConfig() {
		return sourceInputFeedConfig;
	}


	public void setSourceInputFeedConfig(Map<String, SourceInputFeedConfig> sourceInputFeedConfig) {
		this.sourceInputFeedConfig = sourceInputFeedConfig;
	}


	public Map<String, SourceOutFeedConfig> getSourceOutFeedConfig() {
		return sourceOutFeedConfig;
	}


	public void setSourceOutFeedConfig(Map<String, SourceOutFeedConfig> sourceOutFeedConfig) {
		this.sourceOutFeedConfig = sourceOutFeedConfig;
	}
	
	
	
	public Map<String, Object> getAdditionalAttributes() {
		return additionalAttributes;
	}


	public void setAdditionalAttributes(Map<String, Object> additionalAttributes) {
		this.additionalAttributes = additionalAttributes;
	}
	
	

}
