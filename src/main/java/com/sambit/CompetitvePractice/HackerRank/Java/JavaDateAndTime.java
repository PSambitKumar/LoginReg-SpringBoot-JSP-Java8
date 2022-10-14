package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Calendar;
import java.util.Locale;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 10:58 AM
 */
public class JavaDateAndTime {
	public static String findDay(int month, int day, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
	}
}
