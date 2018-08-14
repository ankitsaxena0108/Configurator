package com.prudential.core.cbi.scheduleInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ScheduleDetails {
	
	
	 	private RecurrenceType recurrenceType;

	    private String startTime_in_Hr;

	    private String startTime_in_Min;

		private String name;

	    

	    public RecurrenceType getRecurrenceType ()
	    {
	        return recurrenceType;
	    }

	    public void setRecurrenceType (RecurrenceType recurrenceType)
	    {
	        this.recurrenceType = recurrenceType;
	    }

	    public String getStartTime_in_Hr ()
	    {
	        return startTime_in_Hr;
	    }

	    public void setStartTime_in_Hr (String startTime_in_Hr)
	    {
	        this.startTime_in_Hr = startTime_in_Hr;
	    }

	    public String getStartTime_in_Min ()
	    {
	        return startTime_in_Min;
	    }

	    public void setStartTime_in_Min (String startTime_in_Min)
	    {
	        this.startTime_in_Min = startTime_in_Min;
	    }
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}




	    @Override
	    public String toString()
	    {
	        return "ClassPojo [recurrenceType = "+recurrenceType+", startTime_in_Hr = "+startTime_in_Hr+", startTime_in_Min = "+startTime_in_Min+"]";
	    }

}
