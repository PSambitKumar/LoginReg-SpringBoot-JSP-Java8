package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 11/10/2022 - 3:44 PM
 */
public class BreakingTheRecords {

	public static List<Integer> breakingRecords(List<Integer> scores){
		int max = scores.get(0);
		int min = scores.get(0);
		int maxCount = 0;
		int minCount = 0;
		for (int i = 1; i < scores.size(); i++) {
			if (scores.get(i) > max){
				max = scores.get(i);
				maxCount++;
			}
			if (scores.get(i) < min){
				min = scores.get(i);
				minCount++;
			}
		}
		return List.of(maxCount, minCount);
	}

	public static int[] breakingRecords(int[] scores){
		int[] result = new int[2];
		int max = scores[0];
		int min = scores[0];
		int maxCount = 0;
		int minCount = 0;
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
				maxCount++;
			}
			if (scores[i] < min) {
				min = scores[i];
				minCount++;
			}
		}
		result[0] = maxCount;
		result[1] = minCount;
		return result;
	}

}
