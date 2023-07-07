package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 11:23 AM
 */
public class DivisibleSomePairs {
	public static int divisibleSumPairs(int n, int k, List<Integer> ar){
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((ar.get(i) + ar.get(j)) % k == 0) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(divisibleSumPairs(6, 3, List.of(1, 3, 2, 6, 1, 2)));
	}
}
