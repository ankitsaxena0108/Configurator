package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Hourly {
	
	 private String everyHr;

	    public String getEveryHr ()
	    {
	        return everyHr;
	    }

	    public void setEveryHr (String everyHr)
	    {
	        this.everyHr = everyHr;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [everyHr = "+everyHr+"]";
	    }

}
