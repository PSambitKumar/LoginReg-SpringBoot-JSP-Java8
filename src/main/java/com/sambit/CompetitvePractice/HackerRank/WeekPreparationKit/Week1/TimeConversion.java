package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Week1;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 1:49 PM
 */
public class TimeConversion {
	public static String timeConversion(String s) {
		String[] time = s.split(":");
		String hour = time[0];
		String minute = time[1];
		String second = time[2].substring(0, 2);
		String amPm = time[2].substring(2, 4);
		if (amPm.equals("PM")) {
			if (hour.equals("12")) {
				hour = "12";
			} else {
				hour = String.valueOf(Integer.parseInt(hour) + 12);
			}
		} else {
			if (hour.equals("12")) {
				hour = "00";
			} else {
				hour = hour;
			}
		}
		return hour + ":" + minute + ":" + second;
	}

	public static void main(String[] args) {
		System.out.println(timeConversion("12:45:54PM"));
	}
}
