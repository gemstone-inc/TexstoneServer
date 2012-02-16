package com.jpn.gemstone.texstone.server.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static final String DATE_FORMAT_STR = "yyyy_MM_dd";
    public static final String DATE_TIME_FORMAT_STR = "yyyy_MM_dd_HH_mm_SSSS";
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STR, Locale.US);
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT_STR, Locale.US);
    
    public static String getTimeBasedFileName(){
    	return DATE_TIME_FORMAT.format(Calendar.getInstance().getTime());
    }
    
    public static String getDateBasedFileName(){
    	return DATE_FORMAT.format(Calendar.getInstance().getTime());
    }
    public static boolean isSameWeek(Date dt1, Date dt2){
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(dt1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(dt2);
		return 	(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) && 
				(cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR));
	}
}
