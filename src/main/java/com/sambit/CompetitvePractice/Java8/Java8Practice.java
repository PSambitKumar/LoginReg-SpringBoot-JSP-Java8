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

    public static void listOperation() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream()
                .map( i -> i*i)
                .distinct()
                .collect(Collectors.toList());

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.","Canada");
        String G7Countries = G7.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));

        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long count = strList.stream()
                .filter(x -> x.isEmpty())
                .count();

        List<String> filtered = strList.stream()
                .filter(x -> x.length()> 2)
                .collect(Collectors.toList());

        List<String> filtered1 = strList.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        // Count the empty strings
        List<String> strList1 = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long count1 = strList1.stream()
                .filter(x -> x.isEmpty())
                .count();
        System.out.printf("List %s has %d empty strings %n", strList, count1);

        // Count String with length more than 3
        long num = strList1.stream()
                .filter(x -> x.length()> 3)
                .count();
        System.out.printf("List %s has %d strings of length more than 3 %n",
                strList1, num);


        // Count number of String which startswith "a"
        count = strList.stream()
                .filter(x -> x.startsWith("a"))
                .count();
        System.out.printf("List %s has %d strings which startsWith 'a' %n",
                strList, count);

        // Remove all empty Strings from List
        List<String> filtered2 = strList.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, List without Empty Strings : %s %n",
                strList, filtered2);

        // Create a List with String more than 2 characters
        filtered2 = strList.stream()
                .filter(x -> x.length()> 2)
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n",
                strList, filtered2);


        // Convert String to Uppercase and join them using coma
        List<String> G71 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy",
                "U.K.","Canada");
        String G7Countries1 = G71.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(G7Countries1);

        // Create List of square of all distinct numbers
        List<Integer> numbers1 = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct1 = numbers1.stream()
                .map( i -> i*i).distinct()
                .collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n",
                numbers, distinct1);

        //Get count, min, max, sum, and average for numbers
        List<Integer> primes1 = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats1 = primes1.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Highest prime number in List : " + stats1.getMax());
        System.out.println("Lowest prime number in List : " + stats1.getMin());
        System.out.println("Sum of all prime numbers : " + stats1.getSum());
        System.out.println("Average of all prime numbers : " + stats1.getAverage());
    }

    public static void main(String[] args) {
//        findSumAnsAverage();
//        extractOddAndEvenNumbers();
//        orderByNames();
//        streamExample();
        checkOptional();
    }
}
