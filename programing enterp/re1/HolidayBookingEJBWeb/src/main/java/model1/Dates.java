package model1;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public final class Dates {
	public static long toTimeStamp(String date) {
		Date dateNumber =  date.length() > 0 ? Date.valueOf(date) : new Date(System.currentTimeMillis());
		return dateNumber.getTime();
	}
	
	public static int numberOFDays(Date from,Date to) {
	    int daysdiff = 0;
	    long diff = to.getTime() - from.getTime();
	    long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
	    daysdiff = (int) diffDays;
	    return daysdiff;
	}
	
	public static Date getDate(long date) {
		 Timestamp ts=new Timestamp(date);  
         Date dt=new Date(ts.getTime());  
		return dt;
	}

}
