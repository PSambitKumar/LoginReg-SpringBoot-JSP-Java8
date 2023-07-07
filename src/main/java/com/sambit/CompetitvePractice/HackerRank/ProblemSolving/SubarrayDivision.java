package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 11/10/2022 - 3:55 PM
 */
public class SubarrayDivision {

	public static int birthday(List<Integer> a, int d, int m){
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			int sum = 0;
			for (int j = i; j < i + m; j++) {
				if (j < a.size()) {
					sum += a.get(j);
				}
			}
			if (sum == d) {
				count++;
			}
		}
		return count;
	}

	public static int birthday(int[] a, int d, int m){
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < i + m; j++) {
				if (j < a.length) {
					sum += a[j];
				}
			}
			if (sum == d) {
				count++;
			}
		}
		return count;
	}
}
