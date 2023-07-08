package com.sambit.CompetitvePractice.HackerRank.Java;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 20/10/2022 - 12:13 PM
 */
public class JavaAnagrams {
	static boolean isAnaGram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		a = a.toLowerCase();
		b = b.toLowerCase();
		int[] count = new int[26];
		for (int i = 0; i < a.length(); i++) {
			count[a.charAt(i) - 'a']++;
			count[b.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnaGram("anagram", "margana"));
	}
}
