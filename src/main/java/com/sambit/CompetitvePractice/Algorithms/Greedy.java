package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 22/09/2022 - 10:44 AM
 */
public class Greedy {
    public static void greedy(int[] arr, int n, int amount) {
	   for (int i = n - 1; i >= 0; i--) {
		  while (amount >= arr[i]) {
			 amount = amount - arr[i];
			 System.out.print(arr[i] + " ");
		  }
	   }
    }
}
