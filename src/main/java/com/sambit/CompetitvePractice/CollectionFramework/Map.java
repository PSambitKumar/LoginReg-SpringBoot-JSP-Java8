package com.sambit.CompetitvePractice.CollectionFramework;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
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

        System.out.println("====================================");
    }
}
