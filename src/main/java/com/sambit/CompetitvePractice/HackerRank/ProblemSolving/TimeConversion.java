package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 9:26 PM
 */
public class TimeConversion {
	    public static String timeConversion(String s) {
	   String[] time = s.split(":");
	   String hour = time[0];
	   String minute = time[1];
	   String second = time[2].substring(0, 2);
	   String ampm = time[2].substring(2, 4);
	   if (ampm.equals("PM")) {
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
}
