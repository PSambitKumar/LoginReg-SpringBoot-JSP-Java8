package com.sambit.CompetitvePractice.Arrays;

//QUESTION
//Subarray with given sum
//	   Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.
//	   In case of multiple subarrays, return the subarray which comes first on moving from left to right.

import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayWithGivenSum {
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Arrays.sort(arr);
		int pos;
		for (int i = arr.length-1 ; i > 0; i--) {
			int data = arr[i];
			if (data <= s){
			}
		}
		return arrayList;
	}
}
