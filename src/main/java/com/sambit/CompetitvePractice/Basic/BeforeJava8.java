package com.sambit.CompetitvePractice.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 19/02/2023 - 11:11 PM
 */
public class BeforeJava8 {

    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "Sambit");
        List<String> result = getFilterOutput(lines);
        for (String temp : result) {
            System.out.println(temp);
        }

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        List<Integer> square = map(numbers);
        for (Integer temp : square) {
            System.out.println(temp);
        }

    }

    private static List<Integer> map(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            result.add(number * number);
        }
        return result;
    }

    private static List<String> getFilterOutput(List<String> lines) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"Sambit".equals(line)) {
                result.add(line);
            }
        }
        return result;
    }

    public static List<String> getFilterOutputJava8(List<String> lines) {
        List<String> result;
        result = lines.stream()               // convert list to stream
                .filter(line -> !"Sambit".equals(line))    // we dont like Sambit
                .collect(Collectors.toList());             // collect the output and convert streams to a List
        return result;
    }
}
