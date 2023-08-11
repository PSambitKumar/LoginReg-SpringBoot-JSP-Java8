package com.sambit.CompetitvePractice.CollectionFramework;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 12/12/2022 - 5:25 PM
 */
public class Map {
    public static void main(String[] args) {
        java.util.Map<String, String> map = new java.util.HashMap<>();
        map.put("id", "1");
        map.put("name", "Sambit");
        map.put("age", "26");

        for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

//        Iterate map using Java 8 forEach and lambda
        map.forEach((k, v) -> {
            System.out.println("Key : " + k + " Value : " + v);
        });

        System.out.println("====================================");

        java.util.Map<String, String> map1 = new java.util.LinkedHashMap<>();
        map1.put("id", "1");
        map1.put("name", "Sambit");
        map1.put("age", "26");

        for (java.util.Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("====================================");
    }
}
