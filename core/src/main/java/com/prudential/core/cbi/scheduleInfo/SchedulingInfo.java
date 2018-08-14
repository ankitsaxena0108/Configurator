package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class SchedulingInfo {

	private ScheduleDetails scheduleDetails;


	public ScheduleDetails getScheduleDetails() {
		return scheduleDetails;
	}


	public void setScheduleDetails(ScheduleDetails scheduleDetails) {
		this.scheduleDetails = scheduleDetails;
	}


	@Override
	public String toString() {
		return "ClassPojo [scheduleDetails = " + scheduleDetails + "]";
	}
}
