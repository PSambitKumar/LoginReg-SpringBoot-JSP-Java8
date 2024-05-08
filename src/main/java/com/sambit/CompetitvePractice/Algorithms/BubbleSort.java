package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 07-May-2024 : 3:52 PM
 */


/*Time Complexity: O(N2)
Auxiliary Space: O(1)*/
public class BubbleSort {

    public void sort(int[] array) {
        boolean swapped = false;
        for (int i = 0; i < array.length; i ++) {
            swapped = false;
           for (int j = 0; j < array.length - i -1; j++) {
               if (array[j] > array[j+1]) {
                   int temp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = temp;

                   swapped = true;
               }
           }

           if (!swapped) break;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print((array[i]) + (i != array.length - 1 ?  ", " : ""));
        }
    }
}
