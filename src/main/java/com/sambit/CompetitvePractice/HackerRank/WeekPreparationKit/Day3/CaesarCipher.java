package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day3;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 15/10/2022 - 10:46 AM
 */
public class CaesarCipher {
    public static void main(String[] args) {
	   System.out.println(caesarCipher("middle-Outz", 2));
    }

    static String caesarCipher(String s, int k) {
	   char[] chars = s.toCharArray();
	   for (int i = 0; i < chars.length; i++) {
		  if (chars[i] >= 'a' && chars[i] <= 'z') {
			 chars[i] = (char) ('a' + (chars[i] - 'a' + k) % 26);
		  } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
			 chars[i] = (char) ('A' + (chars[i] - 'A' + k) % 26);
		  }
	   }
	   return new String(chars);
    }
}
