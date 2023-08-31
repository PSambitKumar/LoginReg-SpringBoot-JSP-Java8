package com.sambit.CompetitvePractice.Basic;

import java.util.HashMap;

public class FinalCountWords {

    public static void main(String[] args) {
        String str = "This this is is done by Saket Saket";
        String[] split = str.split(" ");

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (String s : split) {
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.put(s, count + 1);
            } else
                map.put(s, 1);
        }
        System.out.println(map);
    }
}