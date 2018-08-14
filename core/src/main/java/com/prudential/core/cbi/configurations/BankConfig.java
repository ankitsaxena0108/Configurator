package com.prudential.core.cbi.configurations;


public class BankConfig {
	
	String bankCode;
	String category;
	String paymentType;
	String cronConfig;
	
	

	
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
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


	
	public String getCronConfig() {
		return cronConfig;
	}

	public void setCronConfig(String cronConfig) {
		this.cronConfig = cronConfig;
	}


	
	

}
