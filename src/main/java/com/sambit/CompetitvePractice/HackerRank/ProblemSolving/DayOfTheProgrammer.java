package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.UUID;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 18/10/2022 - 11:01 AM
 */
public class DayOfTheProgrammer {

    static String dayOfProgrammer(int year) {
	   if (year == 1918) {
		  return "26.09.1918";
	   } else if (year < 1918) {
		  if (year % 4 == 0) {
			 return "12.09." + year;
		  } else {
			 return "13.09." + year;
		  }
	   } else {
		  if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			 return "12.09." + year;
		  } else {
			 return "13.09." + year;
		  }
	   }
    }

	public static void main(String[] args) {
	    System.out.println(dayOfProgrammer(2017));
	    System.out.println(dayOfProgrammer(2016));
	    System.out.println(dayOfProgrammer(1800));
	    System.out.println(dayOfProgrammer(1918));
	}

}
