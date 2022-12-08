package com.sambit.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//@Auther : Sambit Kumar Pradhan
public class DaysBetweenDates {
	public static float daysCountBetweenDates(Date createdDate){
		float daysBetween = 0;

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
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		try {
			Date createdDate1 = myFormat.parse(fromDate);
			Date currentDate1 = myFormat.parse(toDate);
			long difference = (createdDate1.getTime()-currentDate1.getTime());
			daysBetween = (int)(difference / (1000*60*60*24));
			System.out.println("Number of Days : "+daysBetween);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return daysBetween;
	}

	public static void main(String[] args) {
		int totalDays = totalDaysBetweenDates("02 11 2021", "02 12 2022");
	}
}
