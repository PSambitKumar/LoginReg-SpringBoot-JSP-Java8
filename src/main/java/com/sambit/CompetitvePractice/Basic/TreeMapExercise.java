package com.sambit.CompetitvePractice.Basic;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 31-Oct-2023 : 6:35 PM
 */

public class TreeMapExercise {
    public static void main(String args[]){
        TreeMap<Integer,String> tree_map= new TreeMap<>();
        tree_map.put(1, "Red");
        tree_map.put(2, "Green");
        tree_map.put(3, "Black");
        tree_map.put(4, "White");
        tree_map.put(5, "Blue");

        for (Map.Entry<Integer,String> entry : tree_map.entrySet()) {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }
    }
}
