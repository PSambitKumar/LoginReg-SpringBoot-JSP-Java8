package com.sambit.CompetitvePractice.Algorithms;

import java.util.*;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 07-May-2024 : 11:50 AM
 */

public class Sort {
    public static void main(String[] args) {
//        List<Integer> integerList = Arrays.asList(3, 4, 6, 1, 0);
//        System.out.println(usingOfCollection(integerList));

        sortIntergerArray();
    }

    private static List<Integer> usingOfCollection(List<Integer> integerList) {
         Collections.sort(integerList);
         return integerList;
    }

    private static void sortIntergerArray() {
        int[] intArr = new int[4];

        for (int i = 0; i < intArr.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number for array: ");
            int input = scanner.nextInt();
            intArr[i] = input;
        }

        for (int i = 0; i < intArr.length; i++) {
            System.out.print((intArr[i]) + (i != intArr.length - 1 ?  ", " : ""));
        }
        System.out.println();

//        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.sortByComparingMin(intArr);
//        selectionSort.sortAscending(intArr);
//        selectionSort.sortDescending(intArr);

//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(intArr);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(intArr);
    }
}
