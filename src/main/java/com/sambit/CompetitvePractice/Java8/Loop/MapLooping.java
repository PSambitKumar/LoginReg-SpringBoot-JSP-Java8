package com.sambit.CompetitvePractice.Java8.Loop;

import com.sambit.Utils.EnglishToOriya;

import java.util.Map;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/04/2023 - 2:48 PM
 */
public class MapLooping {
    public static void main(String[] args) {
        Map<Integer, String> nameMap = Map.of(1, "Sambit", 2, "Kumar", 3, "Pradhan");
        nameMap.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));

        nameMap.forEach((key, value) -> {
            System.out.println("Key: " + key + " Value: " + value);
        });

        String str = "Java";
        System.out.println(EnglishToOriya.convertEnglishToOriya(str));

        Map<Integer, String> languages = new java.util.HashMap<>(Map.of(1, "Java", 2, "Python", 3, "C++", 4, "C#", 5, "JavaScript"));
        languages.forEach((key, value) -> {
            if(value.equals("Java"))
                System.out.println("Programming Language: " + value);
        });
        languages.replace(1, "Java", "Kotlin");//Replaces Java and Put Kotlin
        languages.forEach((key, value) -> {
            if(value.equals("Kotlin"))
                System.out.println("Key: " + key + " Programming Language: " + value);
        });
    }
}
