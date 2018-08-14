package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Monthly
{
    private String monthlyFreType;
    
	private String day="0";
    private String week="0";

	private String the="0";
    private String month="0";

    public String getMonthlyFreType() {
		return monthlyFreType;
	}



	public void setMonthlyFreType(String monthlyFreType) {
		this.monthlyFreType = monthlyFreType;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getWeek() {
		return week;
	}



	public void setWeek(String week) {
		this.week = week;
	}
	
	 public String getThe() {
			return the;
		}



		public void setThe(String the) {
			this.the = the;
		}



		public String getMonth() {
			return month;
		}



		public void setMonth(String month) {
			this.month = month;
		}


    @Override
    public String toString()
    {
        return "ClassPojo [monthlyFreType = "+monthlyFreType+", day = "+day+", week = "+week+"]";
    }
}