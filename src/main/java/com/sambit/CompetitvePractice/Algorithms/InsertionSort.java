package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 08-May-2024 : 11:04 AM
 */

public class InsertionSort {

    public void sort(int[] array) {
        try {
            for (int i = 1; i < array.length; i++) {
                int key = array[i];
                int j = i - 1;

                while (array[j] > key && j >= 0) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
                array[j + 1] = key;
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print((array[i]) + (i != array.length - 1 ?  ", " : ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
