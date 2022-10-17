package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day1;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 12:28 PM
 */
public class PlusMinus {
	public static void plusMinus(List<Integer> arr){
		int positive = 0, negative = 0, zero = 0;
		for (Integer integer : arr) {
			if (integer > 0) {
				positive++;
			} else if (integer < 0) {
				negative++;
			} else {
				zero++;
			}
		}
		System.out.println((double)positive/arr.size());
		System.out.println((double)negative/arr.size());
		System.out.println((double)zero/arr.size());
	}

	public static void main(String[] args) {
		plusMinus(List.of(-4, 3, -9, 0, 4, 1));
	}
}
