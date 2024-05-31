package com.sambit.CompetitvePractice.Java8;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 21-May-2024 : 4:27 PM
 */

public class Java8Practice {

    public static void main(String[] args) {

    }

    public void sumUsingJava8() {
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

    private String formatNumber(Object number) {
        return Optional.ofNullable(number)
                .map(Object::toString)
                .map(String::trim)
                .map(Long::parseLong)
                .map(num -> NumberFormat.getNumberInstance(Locale.US).format(num))
                .orElse("NA");
    }
}
