package com.sambit.CompetitvePractice.HackerRank.Certification.ProblemSolvingBasic;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 9:47 PM
 */
public class VowelSubstring {

//	Vowel-Substring
public static String findSubstring(String s, int k) {
	    int max = 0;
    String maxString = "";
    for (int i = 0; i <= s.length() - k; i++) {
	   String subString = s.substring(i, i + k);
	   int count = 0;
	   for (int j = 0; j < subString.length(); j++) {
		  if (subString.charAt(j) == 'a' || subString.charAt(j) == 'e' || subString.charAt(j) == 'i' || subString.charAt(j) == 'o' || subString.charAt(j) == 'u') {
			 count++;
		  }
	   }
	   if (count > max) {
		  max = count;
		  maxString = subString;
	   }
    }
    return maxString;
}

	public static String findSubstring1(String s, int k) {
		int max = 0;
		String maxString = "";
		for (int i = 0; i <= s.length() - k; i++) {
			String subString = s.substring(i, i + k);
			int count = 0;
			for (int j = 0; j < subString.length(); j++) {
				if (subString.charAt(j) == 'a' || subString.charAt(j) == 'e' || subString.charAt(j) == 'i' || subString.charAt(j) == 'o' || subString.charAt(j) == 'u') {
					count++;
				}
			}
			if (count > max) {
				max = count;
				maxString = subString;
			}
		}
		return maxString;
	}

	public static String findSubString2(String s, int k){
		int max = 0;
		String maxString = "";
		for (int i = 0; i < s.length() - k + 1; i++) {
			int count = 0;
			for (int j = i; j < i + k; j++) {
				if (isVowel(String.valueOf(s.charAt(j)))){
					count++;
				}
			}
			if (count > max){
				max = count;
				maxString = s.substring(i, i + k);
			}
		}
		return maxString;
	}


	public static int findSubstring3(String s, int k) {
		int count = 0;
		for (int i = 0; i < s.length() - k + 1; i++) {
			String sub = s.substring(i, i + k);
			if (isVowel(sub)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isVowel(String sub) {
		for (int i = 0; i < sub.length(); i++) {
			if (sub.charAt(i) != 'a' && sub.charAt(i) != 'e' && sub.charAt(i) != 'i' && sub.charAt(i) != 'o' && sub.charAt(i) != 'u') {
				return false;
			}
		}
		return true;
	}

}
