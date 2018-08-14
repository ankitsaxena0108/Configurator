package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Daily {

	
	private String daily;

	    public String getDaily ()
	    {
	        return daily;
	    }

	    public void setDaily (String daily)
	    {
	        this.daily = daily;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [daily = "+daily+"]";
	    }
}
