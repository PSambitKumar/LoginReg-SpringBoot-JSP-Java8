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
        int[] intArr = new int[6];

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

        sortArrayUsingLoopAndMinValue(intArr);
    }

    /*
    Sort array using ascending order.
    Algorithm: Variation of the Selection Sort algorithm.
    Time Complexity: The time complexity of the algorithm is O(n^2), where n is the number of elements in the array.
     Space Complexity: the space complexity of the algorithm is O(n)
    */
    private static void sortArrayUsingLoopAndMinValue(int[] arr) {
        int arrSize = arr.length;
        for (int i = 0; i < arrSize; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arrSize; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print((arr[i]) + (i != arr.length - 1 ?  ", " : ""));
        }
    }


}
