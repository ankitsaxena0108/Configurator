package com.prudential.core.common.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtils {
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
	private static final Logger LOG = LoggerFactory.getLogger(DateUtils.class);
	
	private DateUtils() {
		super();
	}

	public static Date getCurrentDate()
	{
		Calendar cal = Calendar.getInstance();
		return new Date(cal.getTime().getTime());
	}

	public static Timestamp getCurrentDateAsTimeStamp() {
		Calendar cal = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(cal.getTime().getTime());
		LOG.debug("Getting currentDate as Timestamp: {}", timestamp);
		return timestamp;
	}

	public static Date addDaysToDate(int unit) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, unit);
		return new Date(cal.getTimeInMillis());
	}
	
	public static Timestamp now() {
	    return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	
	public static Timestamp endOfDay(Timestamp date) {
        Calendar cal = Calendar.getInstance();    
        cal.setTimeInMillis(date.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 23); //set hour to last hour
        cal.set(Calendar.MINUTE, 59); //set minutes to last minute
        cal.set(Calendar.SECOND, 59); //set seconds to last second
        cal.set(Calendar.MILLISECOND, 999); //set milliseconds to last millisecond
        return new Timestamp(cal.getTimeInMillis());
    }
	
	public static Timestamp getTimeStampForGivenDate(Date date)
	{
		return new Timestamp(date.getTime());
	}

	
	/**
	 *  1999-12-31T18:30:00.000Z
	 * @param fromDate
	 * @return
	 */
	public static Timestamp convertStringToTimeStamp(String fromDate) {
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

	    java.util.Date parsedDate = null;
	    Timestamp timestamp = null;
	    
		try {
			parsedDate = dateFormat.parse(fromDate);
			timestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch (ParseException parseException) {
			LOG.warn("Failed to parse {}, check if it adheres to {} pattern", fromDate, DEFAULT_DATE_FORMAT, parseException);
		}
		
	    return timestamp;
	}
	
	
	
	
	
	
}
