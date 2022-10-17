package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day2;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 9:03 AM
 */
public class LonelyInteger {
	public static int lonelyInteger(List<Integer> a) {
		int result = 0;
		for (Integer integer : a) {
			result ^= integer;
		}
		return result;
	}

	public static int lonelyInteger(int[] a){
		int result = 0;
		for (int j : a) {
			result ^= j;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(lonelyInteger(List.of(1, 2, 3, 4, 3, 2, 1)));
		System.out.println(lonelyInteger(new int[]{1, 2, 3, 4, 3, 2, 1}));
	}
}
