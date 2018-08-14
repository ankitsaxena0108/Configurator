package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Week {
	
	private String month;

    private String day;

    private String week;

    public String getMonth ()
    {
        return month;
    }

    public void setMonth (String month)
    {
        this.month = month;
    }

    public String getDay ()
    {
        return day;
    }

    public void setDay (String day)
    {
        this.day = day;
    }

    public String getWeek ()
    {
        return week;
    }

    public void setWeek (String week)
    {
        this.week = week;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [month = "+month+", day = "+day+", week = "+week+"]";
    }

}
