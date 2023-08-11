package com.sambit.CompetitvePractice.Basic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 01/06/2023 - 7:51 PM
 */
public class StringSplit {

    public static List<String> split(String str){
        return Stream.of(str.split(","))
                .map (String::new)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        split("Sambit,Kumar,Pradhan").forEach(System.out::println);
    }
}
