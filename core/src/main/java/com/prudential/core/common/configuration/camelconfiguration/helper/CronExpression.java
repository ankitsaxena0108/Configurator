package com.prudential.core.common.configuration.camelconfiguration.helper;

import java.io.Serializable;

import com.prudential.core.cbi.scheduleInfo.ScheduleDetails;

public class CronExpression implements Serializable {

	private static final long serialVersionUID = -1676663054009319677L;


	public String getCronExpression(ScheduleDetails scheduleDetails) {
		String response = null;
		String cronExp = "";
		
		
		
		if (scheduleDetails.getRecurrenceType().getFreqType().equals("hourly")) {
			String time =scheduleDetails.getStartTime_in_Hr()+":"+scheduleDetails.getStartTime_in_Min();
			String[] time1 = time.split("\\:");
			String[] time2 = time1[1].split("\\ ");
			String hour = "";
			Integer hourInt = Integer.parseInt(time1[0]);
			if (hourInt == 24) {
				hourInt = 0;
			}
			hour = hourInt.toString();

			String minutes = time2[0];
		//	String cronExp = "";

			if (minutes.equals("00")) {
				minutes = "" + 0;
			}

			String timing=scheduleDetails.getRecurrenceType().getHourly().getEveryHr();
			cronExp = "0 " + minutes + " " + hour + "/" + timing + " ? " +  "*" + " " + "*" + " " + "*";
			
			return cronExp.replace(" ", "+");
			
		
		
		} else if (scheduleDetails.getRecurrenceType().getFreqType().equals("daily")) {
			String time =scheduleDetails.getStartTime_in_Hr()+":"+scheduleDetails.getStartTime_in_Min();
			String[] time1 = time.split("\\:");
			String[] time2 = time1[1].split("\\ ");
			String hour = "";
			Integer hourInt = Integer.parseInt(time1[0]);
			if (hourInt == 24) {
				hourInt = 0;
			}
			hour = hourInt.toString();

			String minutes = time2[0];
		//	String cronExp = "";

			if (minutes.equals("00")) {
				minutes = "" + 0;
			}
		
		
			cronExp = "0 " + minutes + " " + hour + " " + "*" + " " + "*" + " ? " + "*";
			
			return cronExp.replace(" ", "+");
		
		
		} else if (scheduleDetails.getRecurrenceType().getFreqType().equals("weekly")) {

			String time =scheduleDetails.getStartTime_in_Hr()+":"+scheduleDetails.getStartTime_in_Min();
			String[] time1 = time.split("\\:");
			String[] time2 = time1[1].split("\\ ");
			String hour = "";
			Integer hourInt = Integer.parseInt(time1[0]);
			if (hourInt == 24) {
				hourInt = 0;
			}
			hour = hourInt.toString();

			String minutes = time2[0];
		//	String cronExp = "";

			if (minutes.equals("00")) {
				minutes = "" + 0;
			}
			
				String daysString = "";
				StringBuilder sb = new StringBuilder(800);
				boolean moreConditions = false;

				if (scheduleDetails.getRecurrenceType().getWeekly().getSun()) {
					sb.append("SUN");
					moreConditions = true;
				}

				if (scheduleDetails.getRecurrenceType().getWeekly().getMon()) {
					if (moreConditions) {
						sb.append(",");
					}
					sb.append("MON");
					moreConditions = true;
				}

				if (scheduleDetails.getRecurrenceType().getWeekly().getTue()) {
					if (moreConditions) {
						sb.append(",");
					}

					sb.append("TUE");
					moreConditions = true;
				}

				if (scheduleDetails.getRecurrenceType().getWeekly().getWed()) {
					if (moreConditions) {
						sb.append(",");
					}

					sb.append("WED");
					moreConditions = true;
				}

				if (scheduleDetails.getRecurrenceType().getWeekly().getThu()) {
					if (moreConditions) {
						sb.append(",");
					}
					sb.append("THU");
					moreConditions = true;
				}

				if (scheduleDetails.getRecurrenceType().getWeekly().getFri()) {
					if (moreConditions) {
						sb.append(",");
					}
					sb.append("FRI");
					moreConditions = true;
				}

				if (scheduleDetails.getRecurrenceType().getWeekly().getSat()) {
					if (moreConditions) {
						sb.append(",");
					}
					sb.append("SAT");
					moreConditions = true;
				}

				daysString = sb.toString();

				if (minutes.equals("00")) {
					minutes = "" + 0;
				}
				
				
			cronExp = "0 " + minutes + " " + hour + " ? * " + daysString + " " + "*";
			
			return cronExp.replace(" ", "+");
		
		
		
		
		
		
		} else if (scheduleDetails.getRecurrenceType().getFreqType().equals("monthly")) {

			String time =scheduleDetails.getStartTime_in_Hr()+":"+scheduleDetails.getStartTime_in_Min();
			String[] time1 = time.split("\\:");
			String[] time2 = time1[1].split("\\ ");
			String hour = "";
			Integer hourInt = Integer.parseInt(time1[0]);
			if (hourInt == 24) {
				hourInt = 0;
			}
			hour = hourInt.toString();

			String minutes = time2[0];
		//	String cronExp = "";

			if (minutes.equals("00")) {
				minutes = "" + 0;
			}
		
		    if(scheduleDetails.getRecurrenceType().getMonthly().getMonthlyFreType().equals("day")) {
		
			String startDate = scheduleDetails.getRecurrenceType().getMonthly().getDay()+"-"+scheduleDetails.getRecurrenceType().getMonthly().getMonth();
			String[] dateArray = startDate.split("\\-");
			String day = dateArray[0];
			if (day.charAt(0) == '0') {
				day = day.substring(1);
			}

			String month = dateArray[1];

			if (month.charAt(0) == '0') {
				month = month.substring(1);
			}

			/*
			 * String year = dateArray[2]; cronExp = "0 " + minutes + " " + hour + " " + day
			 * + " " + month + " ? " + year;
			 */

			if (minutes.equals("00")) {
				minutes = "" + 0;
			}
			cronExp = "0 " + minutes + " " + hour + " " + day + " " + month + " ? "  + "*";

			return cronExp.replace(" ", "+");
		
		    }else {
		    	
		    	
		    	
		    	
		    }
		
		}

		return response;

	}

	
	String startDate;
	String time;
	boolean recurring;
	boolean SUN;
	boolean MON;
	boolean TUE;
	boolean WED;
	boolean THU;
	boolean FRI;
	boolean SAT;

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * The date set should be of the format (MM-DD-YYYY for example 25-04-2011)
	 * 
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * The time set should be of the format (HH:MM AM/PM for example 12:15 PM)
	 * 
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	public boolean isRecurring() {
		return recurring;
	}

	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	public boolean isSUN() {
		return SUN;
	}

	public void setSUN(boolean sUN) {
		SUN = sUN;
	}

	public boolean isMON() {
		return MON;
	}

	/**
	 * @param mON
	 *            the mON to set
	 */
	public void setMON(boolean mON) {
		MON = mON;
	}

	public boolean isTUE() {
		return TUE;
	}

	public void setTUE(boolean tUE) {
		TUE = tUE;
	}

	public boolean isWED() {
		return WED;
	}

	public void setWED(boolean wED) {
		WED = wED;
	}

	public boolean isTHU() {
		return THU;
	}

	public void setTHU(boolean tHU) {
		THU = tHU;
	}

	public boolean isFRI() {
		return FRI;
	}

	public void setFRI(boolean fRI) {
		FRI = fRI;
	}

	public boolean isSAT() {
		return SAT;
	}

	public void setSAT(boolean sAT) {
		SAT = sAT;
	}

	public int hashCode() {
		return this.getCronExpression(null).hashCode();
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof CronExpression) {
			if (((CronExpression) obj).getCronExpression(null).equalsIgnoreCase(this.getCronExpression(null))) {
				return true;
			}
		} else {
			return false;
		}
		return false;

	}

}
