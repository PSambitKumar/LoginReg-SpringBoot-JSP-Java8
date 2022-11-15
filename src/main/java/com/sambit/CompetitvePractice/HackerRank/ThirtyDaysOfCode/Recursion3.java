package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 15/11/2022 - 4:47 PM
 */
public class Recursion3 {
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(factorial(3));
	}
}
