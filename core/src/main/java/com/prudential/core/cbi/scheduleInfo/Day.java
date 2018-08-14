package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Day {
	
	private String ofEvery;

    private String Day;

    public String getOfEvery ()
    {
        return ofEvery;
    }

    public void setOfEvery (String ofEvery)
    {
        this.ofEvery = ofEvery;
    }

    public String getDay ()
    {
        return Day;
    }

    public void setDay (String Day)
    {
        this.Day = Day;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ofEvery = "+ofEvery+", Day = "+Day+"]";
    }

}
