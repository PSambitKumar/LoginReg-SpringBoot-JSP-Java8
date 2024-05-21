package com.sambit.CompetitvePractice.StringManupulation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 13-May-2024 : 3:53 PM
 */

public class CheckAnagram {


    public static void main(String[] args) {
        checkStringAnagramOrNot("Sambit", "itbsma");
    }

    public static void checkStringAnagramOrNot(String string1, String string2) {
        char[] charArr1 = string1.toLowerCase().toCharArray();
        char[] charArr2 = string2.toLowerCase().toCharArray();


        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (char c : charArr1) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> charCountMap1 = new LinkedHashMap<>();
        for (char c : charArr2) {
            charCountMap1.put(c, charCountMap1.getOrDefault(c, 0) + 1);
        }

        if (charCountMap.equals(charCountMap1))
            System.out.println("Anagram");
        else
            System.out.println("Not an Anagram");

    }
}
