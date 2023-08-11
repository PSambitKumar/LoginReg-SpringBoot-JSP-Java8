package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 8:05 PM
 */
public class SimpleArraySum {
//	Method 1
	public static int simpleArraySum(List<Integer> ar) {
		int sum = 0;
		for (Integer integer : ar) {
			sum += integer;
		}
		return sum;
	}

//	Method 2
	public static int simpleArraySum(int[] ar) {
		int sum = 0;
		for (int j : ar) {
			sum += j;
		}
		return sum;
	}
}
