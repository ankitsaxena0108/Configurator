package com.prudential.core.cbi.scheduleInfo;

public class AdditionalInfo {

	
	String name;
	String category;	
	String paymentType;	
	String scheduleType;
	OtherConfig otherConfig;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getScheduleType() {
		return scheduleType;
	}
	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}
	public OtherConfig getOtherConfig() {
		return otherConfig;
	}
	public void setOtherConfig(OtherConfig otherConfig) {
		this.otherConfig = otherConfig;
	}
	
	
	@Override
	public String toString() {
		return "AdditionalInfo [name=" + name + ", category=" + category + ", paymentType=" + paymentType
				+ ", scheduleType=" + scheduleType + ", otherConfig=" + otherConfig + "]";
	}
	
	
	
}
