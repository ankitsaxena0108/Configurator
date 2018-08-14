package com.prudential.core.common.configuration.excel.bank;

import java.util.LinkedHashMap;
import java.util.Map;

import com.prudential.core.common.configuration.excel.EndpointConfig;


public final class BankFeedConfig {
	
	private Map<String,EndpointConfig> sources = new LinkedHashMap<String, EndpointConfig>();
	private Map<String,EndpointConfig> banks =  new LinkedHashMap<String, EndpointConfig>();
	
	public Map<String, EndpointConfig> getSources() {
		return sources;
	}
	
	void addSource(String name, EndpointConfig endpointConfig) {
		this.sources.put(name,endpointConfig);
	}
	
	public Map<String, EndpointConfig> getBanks() {
		return banks;
	}
	
	void addBank(String name, EndpointConfig endpointConfig) {
		this.banks.put(name,endpointConfig);
	}
}
