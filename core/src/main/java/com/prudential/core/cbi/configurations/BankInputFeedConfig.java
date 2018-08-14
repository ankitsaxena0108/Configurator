package com.prudential.core.cbi.configurations;

public class BankInputFeedConfig {
	
	String filenamePattern;
	
	String locationUri;
	
	String parserConfig;

	public String getFilenamePattern() {
		return filenamePattern;
	}

	public void setFilenamePattern(String filenamePattern) {
		this.filenamePattern = filenamePattern;
	}

	public String getLocationUri() {
		return locationUri;
	}

	public void setLocationUri(String locationUri) {
		this.locationUri = locationUri;
	}

	public String getParserConfig() {
		return parserConfig;
	}

	public void setParserConfig(String parserConfig) {
		this.parserConfig = parserConfig;
	}
	

}
