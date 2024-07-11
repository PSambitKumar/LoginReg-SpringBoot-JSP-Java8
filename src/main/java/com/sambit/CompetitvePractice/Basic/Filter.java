package com.sambit.CompetitvePractice.Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 11-Jul-2024 : 2:29 PM
 */

public class Filter {

        public static <T> List<T> filterList(List<T> originalList, Predicate<T> predicate) {
            return originalList.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
        }

        public static void main(String[] args) {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
            System.out.println("Original list of numbers: " + numbers);
            List<Integer> evenNumbers = filterList(numbers, n -> n % 2 == 0);
            System.out.println("Even numbers: " + evenNumbers);

            List<Integer> oddNumbers = filterList(numbers, n -> n % 2 != 0);
            System.out.println("Odd numbers: " + oddNumbers);

            List<String> colors = List.of("Red", "Green", "White", "Orange", "Black", "Pink");
            System.out.println("\nOriginal list of Colors: " + colors);
            List<String> wordsStartingWithO = filterList(colors, color -> color.startsWith("O"));
            System.out.println("Colors starting with 'O': " + wordsStartingWithO);

            List<String> wordsLengthGreaterThan4 = filterList(colors, color -> color.length() > 4);
            System.out.println("Colors with length greater than 4: " + wordsLengthGreaterThan4);
        }
}