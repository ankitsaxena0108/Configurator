package com.prudential.core.cbi.scheduleInfo;

public class SystemDetailRequest {

	String scheduleType;
	String name;
	String category;	
	String paymentType;
	public String getScheduleType() {
		return scheduleType;
	}
	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}
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
	@Override
	public String toString() {
		return "SystemDetail [scheduleType=" + scheduleType + ", name=" + name + ", category=" + category
				+ ", paymentType=" + paymentType + "]";
	}	
	
	
}
