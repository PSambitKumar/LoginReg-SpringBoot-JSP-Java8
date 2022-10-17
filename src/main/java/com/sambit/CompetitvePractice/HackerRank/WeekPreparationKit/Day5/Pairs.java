package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day5;

import java.util.Collections;
import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 17/10/2022 - 12:21 PM
 */
public class Pairs {

//	Final(Working Perfectly) All Test Case Passed(Time Complexity O(nlogn))
	public static int pairs(int k, List<Integer> arr) {
		int n = arr.size();
		int count = 0;
		Collections.sort(arr);
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			while (j < n && arr.get(j) - arr.get(i) < k) {
				j++;
			}
			if (j < n && arr.get(j) - arr.get(i) == k) {
				count++;
			}
		}
		return count;
	}

//	Time Exceeded
//	public static int pairs(int k, List<Integer> arr){
//		int count = 0;
//		for (int i = 0; i < arr.size(); i++) {
//			for (int j = i + 1; j < arr.size(); j++) {
//				if (Math.abs(arr.get(i) - arr.get(j)) == k) {
//					count++;
//				}
//			}
//		}
//		return count;
//	}

	public static int pairs(int k, int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (Math.abs(arr[i] - arr[j]) == k) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(pairs(2, new int[]{1, 5, 3, 4, 2}));
	}
}
