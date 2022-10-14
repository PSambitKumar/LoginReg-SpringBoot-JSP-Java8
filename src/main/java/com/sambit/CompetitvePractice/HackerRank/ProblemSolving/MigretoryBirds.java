package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 10:45 AM
 */
public class MigretoryBirds {
	public static int migratoryBirds(List<Integer> arr){
		int[] count = new int[5];
		for (Integer integer : arr) {
			count[integer - 1]++;
		}
		int max = 0;
		int result = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max){
				max = count[i];
				result = i + 1;
			}
		}
		return result;
	}
}
