package com.sambit.CompetitvePractice.HackerRank.InterviewPreparationKit.WarmupChallenges;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 11:12 AM
 */
public class RepeatedString {
	public static long repeatedString(String s, long n) {
	   long count = 0;
	   for (int i = 0; i < s.length(); i++) {
		  if (s.charAt(i) == 'a') {
			 count++;
		  }
	   }
	   long factor = n / s.length();
	   long remainder = n % s.length();
	   count = count * factor;
	   for (int i = 0; i < remainder; i++) {
		  if (s.charAt(i) == 'a') {
			 count++;
		  }
	   }
	   return count;
    }

    public static void main(String[] args) {
	   System.out.println(repeatedString("aba", 10));
    }
}
