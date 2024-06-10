package com.sambit.CompetitvePractice.Java8.Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 31-May-2024 : 12:26 PM
 */

public class SumAndAverage {
    public static void main(String[] args) {
        method1();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 6, 7);
        method2(integers);

        // An empty list of integers
        List<Integer> emptyList = Arrays.asList();
        method2(emptyList);
    }

    public static void method1() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 6, 7);

        int sum = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        OptionalDouble average = integers.stream()
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("Sum: " + sum);
        average.ifPresent(avg -> System.out.println("Average: " + avg));
    }

    public static void method2(List<Integer> integers) {
        int sum = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        OptionalDouble average = integers.stream()
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("Sum: " + sum);
        if (average.isPresent())
            System.out.println("Average: " + average.getAsDouble());
        else
            System.out.println("Average: not available (empty list)");
    }

    public static void method3() {
        Optional<String> optionalWithValue = Optional.of("Hello, World!");

        Optional<String> emptyOptional = Optional.empty();

        if (optionalWithValue.isPresent())
            System.out.println("Value is present: " + optionalWithValue.get());
        else
            System.out.println("Value is absent");


        // Use orElse to provide a default value
        String value1 = optionalWithValue.orElse("Default Value");
        System.out.println("Value1: " + value1);

        String value2 = emptyOptional.orElse("Default Value");
        System.out.println("Value2: " + value2);

        // Use orElseGet to provide a value using a supplier
        String value3 = emptyOptional.orElseGet(() -> "Supplied Default Value");
        System.out.println("Value3: " + value3);

        // Use ifPresent to execute a block of code if a value is present
        optionalWithValue.ifPresent(value -> System.out.println("Value is present: " + value));

    }


}
