package com.sambit.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//@Auther : Sambit Kumar Pradhan

@SuppressWarnings("deprecation")
public class DaysBetweenDates {
	public static long daysCountBetweenDates(Date createdDate){
		long daysBetween = 0;

//		For Current Date Using LocalDateTime
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);

//		For Created Date
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd MM yyyy");
		String cDate = sdf1.format(createdDate);
		System.out.println("Created Date : " + cDate + "\nCurrent Date : " + currentDate);

		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");

//		Calculation
		try {
			Date createdDate1 = myFormat.parse(cDate);
			Date currentDate1 = myFormat.parse(currentDate);
			long totalSeconds= currentDate1.getTime() -createdDate1.getSeconds();
			long totalMinutes= currentDate1.getTime() -createdDate1.getMinutes();
			long totalHours = currentDate1.getHours() -createdDate1.getHours();
			long totalDays = currentDate1.getDay() -createdDate1.getDay();
			long totalMonths = currentDate1.getMonth() -createdDate1.getMonth();
			long totalYears = currentDate1.getYear() -createdDate1.getYear();
			long totalTimes = currentDate1.getTime() - createdDate1.getTime();
			System.out.println("Total Times in Long : "+ totalTimes);
			daysBetween = (totalTimes / (1000*60*60*24));
			System.out.println("Number of Seconds : "+((((daysBetween * 24) * 60)) * 60));
			System.out.println("Number of Minutes : "+((daysBetween * 24) * 60));
			System.out.println("Number of Hours : "+daysBetween *  24);
			System.out.println("Number of Days(Manually) : "+((((totalYears* 12)+totalMonths) * 30) + totalDays));
			System.out.println("Number of Months : "+((totalYears* 12)+totalMonths));
			System.out.println("Number of Years : "+totalYears);
			System.out.println("Number of Days : "+daysBetween);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return daysBetween;
	}

	public static int totalDaysBetweenDates(String fromDate, String toDate){
		int daysBetween = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");
//		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		try {
			Date fromDate1 = myFormat.parse(fromDate);
			Date toDate1 = myFormat.parse(toDate);
			long difference = (toDate1.getTime()-fromDate1.getTime());
			daysBetween = (int)(difference / (1000*60*60*24));
			System.out.println("Number of Days : "+daysBetween);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return daysBetween;
	}

	public static long daysBetween(String dateOfAdmission, String dateOfDischarge) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		long daysBetween = 0;
		try {
			Date date1 = myFormat.parse(dateOfAdmission);
			Date date2 = myFormat.parse(dateOfDischarge);
			long diff = date2.getTime() - date1.getTime();
			daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return daysBetween;
	}

	public static float totalYearsBetweenDates(String fromDate, String toDate){
		float yearsBetween = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");
		try {
			Date fromDate1 = myFormat.parse(fromDate);
			Date toDate1 = myFormat.parse(toDate);
			long difference = (toDate1.getTime()-fromDate1.getTime());
			yearsBetween = (float)(difference / (1000*60*60*24*365.25));
			System.out.println("Number of Years : "+yearsBetween);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return yearsBetween;
	}

	public static int totalMonthsBetweenDates(String fromDate, String toDate){
		int monthsBetween = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");
		try {
			Date fromDate1 = myFormat.parse(fromDate);
			Date toDate1 = myFormat.parse(toDate);
			monthsBetween = (toDate1.getYear() - fromDate1.getYear()) * 12 + (toDate1.getMonth() - fromDate1.getMonth());
			System.out.println("Number of Months : "+monthsBetween);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return monthsBetween;
	}

	public static void main(String[] args) throws ParseException {
		String fromDate = "08 11 2021";
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		Date createdDate = myFormat.parse(fromDate);
		float days = daysCountBetweenDates(createdDate);
		System.out.println("Number Of Days : " + days);

		int days1 = totalDaysBetweenDates("01012022", "01022023");
		System.out.println("Number Of Days : " + days1);

		float years = totalYearsBetweenDates("01012022", "01022023");
		System.out.println("Number Of Years : " + years);

		int months = totalMonthsBetweenDates("01012022", "01022023");
		System.out.println("Number Of Months : " + months);
	}

	public static int getDaysUsingMonthAndYear(int month, int year){
		return new SimpleDateFormat("dd").format(new Date(year, month, 0)).equals("31") ? 31 : new SimpleDateFormat("dd").format(new Date(year, month, 0)).equals("30") ? 30 : new SimpleDateFormat("dd").format(new Date(year, month, 0)).equals("29") ? 29 : 28;
	}

	public int daysOfMoth() {
		Calendar cal = Calendar.getInstance();
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days;
	}

	public static void daysPrintBetweenDates(Date fromDate, Date toDate) {
		int days = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
		System.out.println("Days : " + days);
		for (int i = 0; i <= days; i++) {
			Date tempDate = new Date(fromDate.getTime() + ((long) i * 24 * 60 * 60 * 1000));
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//				Date tempDate = sdf.parse(sdf.format(fromDate.getTime() + ((long) i * 24 * 60 * 60 * 1000)));
			System.out.println("Temp Date : " + tempDate);
		}
	}
}
