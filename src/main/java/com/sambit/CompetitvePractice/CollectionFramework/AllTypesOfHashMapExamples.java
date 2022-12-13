package com.sambit.CompetitvePractice.CollectionFramework;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/12/2022 - 5:35 PM
 */
public class AllTypesOfHashMapExamples {
    public static void main(String[] args) {
        java.util.Map<String, String> map = new java.util.HashMap<>();
        map.put("id", "1");
        map.put("name", "Sambit");
        map.put("age", "26");

        for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("====================================");

        java.util.Map<String, String> map1 = new java.util.LinkedHashMap<>();
        map1.put("id", "1");
        map1.put("name", "Sambit");
        map1.put("age", "26");

        for (java.util.Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("====================================");

        java.util.Map<String, String> map2 = new java.util.TreeMap<>();
        map2.put("id", "1");
        map2.put("name", "Sambit");
        map2.put("age", "26");

        for (java.util.Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("====================================");

        java.util.Map<String, String> map3 = new java.util.Hashtable<>();
        map3.put("id", "1");
        map3.put("name", "Sambit");
        map3.put("age", "26");

        for (java.util.Map.Entry<String, String> entry : map3.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("====================================");

        java.util.Map<String, String> map4 = new java.util.IdentityHashMap<>();
        map4.put("id", "1");
        map4.put("name", "Sambit");
        map4.put("age", "26");

        for (java.util.Map.Entry<String, String> entry : map4.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("====================================");

        java.util.Map<String, String> map5 = new java.util.WeakHashMap<>();
        map5.put("id", "1");
        map5.put("name", "Sambit");
        map5.put("age", "26");

        for (java.util.Map.Entry<String, String> entry : map5.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
