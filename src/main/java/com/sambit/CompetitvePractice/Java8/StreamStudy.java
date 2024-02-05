package com.sambit.CompetitvePractice.Java8;

import java.util.List;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 05-Feb-2024 : 11:53 AM
 */

public class StreamStudy {
    public static void main(String[] args) {
        List<String> list = List.of("Sambit", "Sourav", "Santosh", "Sourav", "Sambit");
        list.stream().distinct().forEach(System.out::println);

        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list1.stream().filter(num -> num % 2 == 0).forEach(System.out::println);

        List<String> list2 = List.of("Sambit", "Sourav", "Santosh", "Sourav", "Sambit");
        list2.stream().map(String::toUpperCase).forEach(System.out::println);

        List<String> list3 = List.of("Sambit", "Sourav", "Santosh", "Sourav", "Sambit");
        list3.stream().sorted().forEach(System.out::println);
    }
}
