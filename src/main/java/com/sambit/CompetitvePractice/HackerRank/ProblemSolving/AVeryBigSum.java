package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 8:14 PM
 */
public class AVeryBigSum {

//	Method 1
	public static long aVeryBigSum(List<Long> ar) {
		long sum = 0;
		for (Long integer : ar) {
			sum += integer;
		}
		return sum;
	}

//	Method 2
	public static long aVeryBigSum(long[] ar) {
		long sum = 0;
		for (long integer : ar) {
			sum += integer;
		}
		return sum;
	}
}
