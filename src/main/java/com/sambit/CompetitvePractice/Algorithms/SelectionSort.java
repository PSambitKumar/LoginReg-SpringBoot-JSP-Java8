package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 07-May-2024 : 3:48 PM
 */

    /*
    Sort array using ascending order.(Selection Sort)
    Algorithm: Variation of the Selection Sort algorithm.
    Time Complexity: The time complexity of the algorithm is O(n^2), where n is the number of elements in the array.
     Space Complexity: the space complexity of the algorithm is O(n)
    */
public class SelectionSort {

    public void sortByComparingMin(int[] arr) {
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

    public void sortDescending(int[] array) {
        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] > array[i]) {
                        int temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                    }
                }
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortAscending(int[] array) {
        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + ((array.length - 1 == i ? "" : ", " +
                        "")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
