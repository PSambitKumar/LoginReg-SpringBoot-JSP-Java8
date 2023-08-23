/**
 * 
 */
package com.sambit.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author arabinda.guin
 *
 */
public class DateFormat {
	
	public static String FormatToDateString(String date) {
		String dd=date.substring(0, 2);
		String mm=date.substring(2, 4);
		String yy=date.substring(4);
		return mm+"-"+dd+"-"+yy;
	}

	public static Date FormatToDateString1(String date) {
		String dd=date.substring(0, 2);
		String mm=date.substring(2, 4);
		String yy=date.substring(4);
		String date1=mm+"-"+dd+"-"+yy;
		Date date2=null;
		try {
			date2 = new SimpleDateFormat("MM-dd-yyyy").parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date2;
	}
	
	public static String DateString(String date) {
		String dd=date.substring(0, 2);
		String mm=date.substring(2, 4);
		String yy=date.substring(4);
		return dd+"-"+mm+"-"+yy;
	}
	public static String formatDateFun(String dt) {
		String dd=dt.substring(0, 2);
		String mm=dt.substring(2, 4);
		String yy=dt.substring(4);
	    String date1=dd+"-"+mm+"-"+yy;
		 SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		 SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
		    Date date=null;
			try {
				date = format1.parse(date1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return format2.format(date);
	}

	public static String formatDateToTime(Date date) {
		return new SimpleDateFormat("HH:mm:ss a").format(date);
	}

	public static String formatDate(Date date) {
		return new SimpleDateFormat("dd-MMM-yyyy").format(date);
	}

	public static String formatDateWithTime(Date date) {
		return new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(date);
	}
}
