package com.sambit.CompetitvePractice.HackerRank.Java;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 20/10/2022 - 12:04 PM
 */
public class JavaStringComparisons {
	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		for (int i = 0; i <= s.length() - k; i++) {
			String subString = s.substring(i, i + k);
			if (i == 0) {
				smallest = subString;
				largest = subString;
			} else {
				if (subString.compareTo(smallest) < 0) {
					smallest = subString;
				}
				if (subString.compareTo(largest) > 0) {
					largest = subString;
				}
			}
		}
		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {
		String s = "welcometojava";
		int k = 3;
		System.out.println(getSmallestAndLargest(s, k));
	}
}
