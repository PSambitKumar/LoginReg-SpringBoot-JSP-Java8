package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Week1;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 1:30 PM
 */
public class MiniMaxSum {
	public static void miniMaxSum(List<Integer> arr) {
		long min = Long.MAX_VALUE, max = Long.MIN_VALUE, sum = 0;
		for (Integer integer : arr) {
			sum += integer;
			min = Math.min(min, integer);
			max = Math.max(max, integer);
		}
		System.out.println((sum - max) + " " + (sum - min));
	}

	public static void main(String[] args) {
		miniMaxSum(List.of(1, 2, 3, 4, 5));
	}
}
