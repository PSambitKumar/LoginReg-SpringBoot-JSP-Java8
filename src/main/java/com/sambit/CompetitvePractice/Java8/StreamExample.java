package com.sambit.CompetitvePractice.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 19-Mar-2024 : 10:51 AM
 */

public class StreamExample {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long count = strList.stream()
                .filter(x -> x.isEmpty())
                .count();

        System.out.println("String List : " + strList);
        System.out.println("Count : " + count);


        long num = strList.stream()
                .filter(x -> x.length()> 3)
                .count();

        System.out.println("Num : " + num);

        long count1 = strList.stream()
                .filter(x -> x.startsWith("a"))
                .count();

        System.out.println("Count 1 : " + count1);

        List<String> filtered = strList.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());

        System.out.println("Filtered : " + filtered);
    }
}
