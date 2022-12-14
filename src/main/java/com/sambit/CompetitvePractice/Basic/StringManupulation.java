package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/12/2022 - 7:14 PM
 */
public class StringManupulation {
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String capitalizeFirstLetterOfALine(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static int[] countTotalNoOfOccuranceOfEachCharacter(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        return count;
    }
}
