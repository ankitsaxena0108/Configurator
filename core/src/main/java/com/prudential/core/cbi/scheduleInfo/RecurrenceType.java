package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class RecurrenceType {
	
	private String freqType;
	
	private Weekly weekly;

    private Monthly monthly;

    private Hourly hourly;

    private Daily daily;

    public Weekly getWeekly ()
    {
        return weekly;
    }

    public void setWeekly (Weekly weekly)
    {
        this.weekly = weekly;
    }

    public Monthly getMonthly ()
    {
        return monthly;
    }

    public void setMonthly (Monthly monthly)
    {
        this.monthly = monthly;
    }

    public Hourly getHourly ()
    {
        return hourly;
    }

    public void setHourly (Hourly hourly)
    {
        this.hourly = hourly;
    }

    public Daily getDaily ()
    {
        return daily;
    }

    public void setDaily (Daily daily)
    {
        this.daily = daily;
    }
    
    public String getFreqType() {
		return freqType;
	}

	public void setFreqType(String freqType) {
		this.freqType = freqType;
	}

    @Override
    public String toString()
    {
        return "ClassPojo [weekly = "+weekly+", monthly = "+monthly+", hourly = "+hourly+", freqType = "+freqType+", daily = "+daily+"]";
    }

}
