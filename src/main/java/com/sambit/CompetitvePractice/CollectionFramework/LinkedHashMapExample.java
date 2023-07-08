package com.sambit.CompetitvePractice.CollectionFramework;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 22/11/2022 - 1:23 PM
 */
public class LinkedHashMapExample {
    public static void main(String[] args) {
//        LinkedHashMap will return the elements in the order they were inserted into the map
//        when you iterate over the keySet(), entrySet() or values() of the map.

//        This will print the elements in the order they were put into the map:
//        id = 1
//        name = Sambit
//        age = 26

        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", "1");
        map.put("name", "Sambit");
        map.put("age", "26");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
