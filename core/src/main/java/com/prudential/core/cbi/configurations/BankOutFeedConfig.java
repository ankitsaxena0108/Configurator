package com.prudential.core.cbi.configurations;

public class BankOutFeedConfig {

	
	String fileNamePattern;

	String fileHeaderTemplate;
	
	String fileTemplate;
	
	String fileFooterTemplate;
	
	String locationUri;
	
	String filterCondition;

	public String getFileNamePattern() {
		return fileNamePattern;
	}

	public void setFileNamePattern(String fileNamePattern) {
		this.fileNamePattern = fileNamePattern;
	}

	public String getFileHeaderTemplate() {
		return fileHeaderTemplate;
	}

	public void setFileHeaderTemplate(String fileHeaderTemplate) {
		this.fileHeaderTemplate = fileHeaderTemplate;
	}

	public String getFileTemplate() {
		return fileTemplate;
	}

	public void setFileTemplate(String fileTemplate) {
		this.fileTemplate = fileTemplate;
	}

	public String getFileFooterTemplate() {
		return fileFooterTemplate;
	}

	public void setFileFooterTemplate(String fileFooterTemplate) {
		this.fileFooterTemplate = fileFooterTemplate;
	}

	public String getLocationUri() {
		return locationUri;
	}

	public void setLocationUri(String locationUri) {
		this.locationUri = locationUri;
	}

	public String getFilterCondition() {
		return filterCondition;
	}

	public void setFilterCondition(String filterCondition) {
		this.filterCondition = filterCondition;
	}



}
