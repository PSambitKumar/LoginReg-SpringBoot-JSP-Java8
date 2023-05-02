package com.sambit.CompetitvePractice.Java8.Loop;

import com.sambit.Utils.EnglishToOriya;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

//        Count Method Using Stream
        List<Map<String, Object>> mapList = List.of(Map.of("Mango", 5, "Apple", 4, "Orange", 3),
                Map.of("Mango", 6, "Apple", 5, "Orange", 4),
                Map.of("Mango", 7, "Apple", 6, "Orange", 5));

        int mangoCount = mapList.stream()
                .mapToInt(fruit -> (int)fruit.get("Mango")).sum();
        System.out.println("Mango Count: " + mangoCount);

        mapList.forEach(fruit -> {
            fruit.forEach((key, value) -> {
                System.out.println("Key: " + key + " Value: " + value);
            });
        });
    }
}
