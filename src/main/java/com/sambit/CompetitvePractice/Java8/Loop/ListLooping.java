package com.sambit.CompetitvePractice.Java8.Loop;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/04/2023 - 1:59 PM
 */
public class ListLooping {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sambit", "Hrusi", null, "Jyoti");

        names.forEach(System.out::println);

        names.stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);//For Printing Not Null Elements
    }
}
