package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 9:21 PM
 */
public class MinMaxSum {
	public static void miniMaxSum(List<Integer> arr) {
	   long min = Long.MAX_VALUE;
	   long max = Long.MIN_VALUE;
	   long sum = 0;
	   for (Integer integer : arr) {
		  sum += integer;
		  if (integer < min) {
			 min = integer;
		  }
		  if (integer > max) {
			 max = integer;
		  }
	   }
	   System.out.println((sum - max) + " " + (sum - min));
    }

	public static void miniMaxSum(int[] arr) {
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println((sum - max) + " " + (sum - min));
	}
}
