package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day3;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 15/10/2022 - 11:12 AM
 */
public class PalindromeIndex {
    public static void main(String[] args) {
	   System.out.println(palindromeIndex("aaab"));
    }

    static int palindromeIndex(String s) {
	   int st = 0;
	   int ed = s.length() - 1;
	   while (st < ed) {
		  if (s.charAt(st) != s.charAt(ed)) {
			 if (s.charAt(st + 1) == s.charAt(ed) && s.charAt(st + 2) == s.charAt(ed - 1)) {
				return st;
			 } else if (s.charAt(st) == s.charAt(ed - 1) && s.charAt(st + 1) == s.charAt(ed - 2)) {
				return ed;
			 }
		  }
		  st++;
		  ed--;
	   }
	   return -1;
    }
}
