package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class SystemInfo {


	String name;
	String category;	
	String paymentType;	
	String scheduleType;
	ScheduleDetails scheduleDetails;
	
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

	public ScheduleDetails getScheduleDetails() {
		return scheduleDetails;
	}

	public void setScheduleDetails(ScheduleDetails scheduleDetails) {
		this.scheduleDetails = scheduleDetails;
	}




}
