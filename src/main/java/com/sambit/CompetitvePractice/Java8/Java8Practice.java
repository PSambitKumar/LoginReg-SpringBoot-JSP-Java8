package com.sambit.CompetitvePractice.Java8;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 21-May-2024 : 4:27 PM
 */

public class Java8Practice {

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

    private static void findSumAnsAverage() {
        List<Integer> integers = List.of(1, 2, 9, 0, 6, 4, 10);

        OptionalDouble average  = integers.stream()
                .mapToInt(Integer::intValue)
                .average();

        if (average.isPresent())
            System.out.println("Average of the list is: " + average.getAsDouble());
        else
            System.out.println("List is empty to get the average value.");
    }

    public static void extractOddAndEvenNumbers() {
        List<Integer> integers = List.of(1, 9, 8, 10, 11, 98, 3, 6, 7);

        Map<Boolean, List<Integer>> evenOddList= integers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

        evenOddList.get(true).forEach(System.out::println);
        evenOddList.get(false).forEach(System.out::println);
    }

    public static void orderByNames() {
        Map<Integer, String> nameMap = new HashMap<>();
        nameMap.put(1, "Sambit");
        nameMap.put(2, "David");
        nameMap.put(3, "Ashok");
        nameMap.put(7, "Aakash");
        nameMap.put(5, "Pinak");

        Map<Integer, String> sortedNameMap = nameMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) ->e1,
                        LinkedHashMap::new
                ));

        Map<Integer, String> sortedNameById = nameMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        // Print the sorted map
        System.out.println("Sorted By Name: ");
        sortedNameMap.forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("Sorted By Id: ");
        sortedNameById.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    public static void streamExample() {
        List<Integer> integers = List.of(1, 8, 9, 10, 7, 99, 77);

        boolean isPresent = integers.stream().anyMatch(data -> data.equals(88));
        System.out.println("88 " + (isPresent ? "Present" : "Absent"));

        boolean nonMatch = integers.stream().noneMatch(data -> data > 88);
        System.out.println("None of the elements are greater than 88: " + nonMatch);

        List<Map<String, String>> objectList = Stream.of(
                Map.of("id", "1", "subject", "Math", "mark", "80"),
                Map.of("id", "2", "subject", "English", "mark", "78"),
                Map.of("id", "3", "subject", "Science", "mark", "94")
        ).collect(Collectors.toList());

        long totalMark = objectList.stream()
                .mapToLong(map -> Long.parseLong(map.get("mark")))
                .sum();

        System.out.println("Total Mark: " + totalMark);
    }

    public static void checkOptional() {
        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4, 6,7, 25);
        List<Integer> integers2 = Arrays.asList(1, 2, 3, 4, 6, 9, 10, 16);

        List<Integer> common = new ArrayList<>(integers1);
        common.retainAll(integers2);
    }

    public static void main(String[] args) {
//        findSumAnsAverage();
//        extractOddAndEvenNumbers();
//        orderByNames();
//        streamExample();
        checkOptional();
    }
}
