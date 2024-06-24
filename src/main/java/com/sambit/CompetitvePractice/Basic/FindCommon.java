package com.sambit.CompetitvePractice.Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 24-Jun-2024 : 1:08 PM
 */

public class FindCommon {

    public static void method1() {
        List<Integer> integers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 7, 25));
        List<Integer> integers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 9, 10, 16));

        List<Integer> commonList = new ArrayList<>(integers1);
        commonList.retainAll(integers2);

        List<Integer> uncommonList = new ArrayList<>(integers1);
        uncommonList.addAll(integers2);
        List<Integer> tempCommonList = new ArrayList<>(integers1);
        tempCommonList.retainAll(integers2);
        uncommonList.removeAll(tempCommonList);

        System.out.println("Common List: " + commonList);
        System.out.println("Uncommon List: " + uncommonList);
    }
    public static void method2() {
        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4, 6, 7, 25);
        List<Integer> integers2 = Arrays.asList(1, 2, 3, 4, 6, 9, 10, 16);

        List<Integer> commonList = integers1.stream()
                .filter(integers2::contains)
                .collect(Collectors.toList());

        List<Integer> uncommonList = Stream.concat(integers1.stream(), integers2.stream())
                .filter(e -> !commonList.contains(e))
                .collect(Collectors.toList());

        System.out.println("Common List: " + commonList);
        System.out.println("Uncommon List: " + uncommonList);
    }

    public static void main(String[] args) {
        method1();
        method2();
    }
}
