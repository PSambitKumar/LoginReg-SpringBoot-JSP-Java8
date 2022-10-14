package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Week2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 10:08 AM
 */
public class CountingSort1 {

	public static List<Integer> countingSort(List<Integer> arr) {
		int[] count = new int[100];
		for (Integer integer : arr) {
			count[integer]++;
		}
		return Arrays.stream(count).boxed().collect(Collectors.toList());
	}
	
	public static int[] countingSort(int[] arr) {
		int[] result = new int[100];
		for (int i : arr) {
			result[i]++;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(countingSort(List.of(1, 1, 3, 2, 1)));
		System.out.println(Arrays.toString(countingSort(new int[]{1, 1, 3, 2, 1})));
	}
}
