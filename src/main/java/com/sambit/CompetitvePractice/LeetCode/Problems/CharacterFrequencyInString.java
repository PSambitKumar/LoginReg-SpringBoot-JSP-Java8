package com.sambit.CompetitvePractice.LeetCode.Problems;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 31/12/2022 - 11:04 PM
 */
public class CharacterFrequencyInString {
    public static void main(String[] args) {
        String str = "Sambit Kumar Pradhan";
        int[] freq = new int[str.length()];
        System.out.println("The entered string is " + str);
        char[] str1 = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            freq[i] = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (str1[i] == str1[j]) {
                    freq[i]++;
                    str1[j] = '0';
                }
            }
        }
        for (int i = 0; i < freq.length; i++) {
            if (str1[i] != ' ' && str1[i] != '0')
                System.out.println(str1[i] + " " + freq[i]);
        }
    }
}
