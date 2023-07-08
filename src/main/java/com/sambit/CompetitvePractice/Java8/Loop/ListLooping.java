package com.sambit.CompetitvePractice.Java8.Loop;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 13/04/2023 - 1:59 PM
 */
public class ListLooping {
    public static void main(String[] args) {
        ListLoop();
    }

    public static void ListLoop() {
        List<Object> objectList = Arrays.asList(12, "Data");
        List<?> objectList1= Arrays.asList(12, "Data");
//        System.out.println(objectList);
//        System.out.println(objectList1);

        List<Integer> integerList = Arrays.asList(12, 23, 34, 45, 90, 56, 67);
    }

    public static void nonNull() {
        List<String> names = Arrays.asList("Sambit", "Hrusi", null, "Jyoti");
        names.forEach(System.out::println);
        names.stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);//For Printing Not Null Elements
    }
}
