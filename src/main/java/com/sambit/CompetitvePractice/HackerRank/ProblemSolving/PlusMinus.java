package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 8:39 PM
 */
public class PlusMinus {
	public static void plusMinus(int[] arr) {
		int positive = 0;
		int negative = 0;
		int zero = 0;
		for (int i : arr) {
			if (i > 0) {
				positive++;
			} else if (i < 0) {
				negative++;
			} else {
				zero++;
			}
		}
		System.out.println((double) positive / arr.length);
		System.out.println((double) negative / arr.length);
		System.out.println((double) zero / arr.length);
	}

	public static void plusMinus(List<Integer> arr){
		int positive = 0;
		int negative = 0;
		int zero = 0;
		for (Integer i : arr) {
			if (i > 0) {
				positive++;
			} else if (i < 0) {
				negative++;
			} else {
				zero++;
			}
		}
		System.out.println((double) positive / arr.size());
		System.out.println((double) negative / arr.size());
		System.out.println((double) zero / arr.size());
	}
}
