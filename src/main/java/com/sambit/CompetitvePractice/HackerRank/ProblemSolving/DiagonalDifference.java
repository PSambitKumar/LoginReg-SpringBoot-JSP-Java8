package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 8:33 PM
 */
public class DiagonalDifference {
	public static int diagonalDifference(List<List<Integer>> arr) {
	   int sum1 = 0;
	   int sum2 = 0;
	   for (int i = 0; i < arr.size(); i++) {
		  sum1 += arr.get(i).get(i);
		  sum2 += arr.get(i).get(arr.size() - i - 1);
	   }
	   return Math.abs(sum1 - sum2);
    }
}
