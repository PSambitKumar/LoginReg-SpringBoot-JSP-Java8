package com.sambit.CompetitvePractice.Java8.Practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 31-May-2024 : 12:24 PM
 */

public class Sum {



    public static void sumUsingJava8() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 6,7);

        int sum0 = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of integers: " + sum0);

//------------------------------------------------------------


        int sum1 = integers.stream()
                .reduce(0, Integer::sum);

        System.out.println("Sum of integers: " + sum1);

        //------------------------------------------------------------

        int sum2 = integers.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Sum of integers: " + sum2);

        //------------------------------------------------------------

        int sum3 = IntStream.of(integers.stream()
                        .flatMapToInt(IntStream::of)
                        .toArray())
                .sum();

        System.out.println("Sum of integers: " + sum3);

        //------------------------------------------------------------

        IntSummaryStatistics stats = integers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        int sum4 = (int) stats.getSum();

        System.out.println("Sum of integers: " + sum4);

        //------------------------------------------------------------

        int sum5 = integers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of integers: " + sum5);

        //------------------------------------------------------------

        final int[] sum6 = {0};
        integers.stream().forEach(i -> sum6[0] += i);

        System.out.println("Sum of integers: " + sum6[0]);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenIntegers = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(evenIntegers);

        int sumOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Filter even numbers
                .mapToInt(Integer::intValue) // Convert Integer to int
                .sum(); // Sum the even numbers

        System.out.println("Sum of even numbers: " + sumOfEvenNumbers);
    }
}
