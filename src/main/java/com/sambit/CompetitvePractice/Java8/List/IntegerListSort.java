package com.sambit.CompetitvePractice.Java8.List;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 03/05/2023 - 12:09 PM
 */
public class IntegerListSort {
    public static void main(String[] args) {
        sortIntegerList();
    }

    public static void sortIntegerList() {
//        Method 1
        List<Integer> integerList = List.of(1, 4, 3, 6, 7, 15, 87, 54);
        System.out.println("Default Integer List : " + integerList);
        Integer[] numbers = integerList.toArray(new Integer[0]);
        Arrays.sort(numbers);
        System.out.println("Sorted Integer List : " + Arrays.toString(numbers));

//        Method 2
        List<Integer> integerList1 = Arrays.asList(1, 4, 3, 6, 7, 15, 87, 54);
        System.out.println("Default Integer List1 : " + integerList1);
        Collections.sort(integerList1);
        System.out.println("Sorted Integer List1 : " + integerList1);

//        Method 3
        List<Integer> integerList2 = Arrays.asList(1, 4, 3, 6, 7, 15, 87, 54);
        System.out.println("Default Integer List2 : " + integerList2);
        System.out.println("Sorted Integer List2 : " + integerList2.stream().sorted().toList()); //integerList2.stream().sorted().collect(Collectors.toList()) //This Can Also Use

//        Method 4
        List<Integer> integerList3 = Arrays.asList(1, 4, 3, 6, 7, 15, 87, 54, null);
        System.out.println("Default Integer List3 : " + integerList3);
        List<Integer> nonNullIntegerList = integerList3.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println("Non Null Integer List : " + Arrays.toString(nonNullIntegerList.toArray()));
        Collections.sort(nonNullIntegerList, Comparator.naturalOrder());//This Can Use
        nonNullIntegerList.sort(Comparator.naturalOrder());//This also can use
        nonNullIntegerList.sort(Comparator.reverseOrder());//This used for Reverse Order
        System.out.println("Reversed Order Integer List3 : " + nonNullIntegerList);

        //    Method 5
        List<Integer> integerList4 = Arrays.asList(34, 78, 67, 55, 28);
        System.out.println("Default Integer List4 : " + integerList4);
    }
}
