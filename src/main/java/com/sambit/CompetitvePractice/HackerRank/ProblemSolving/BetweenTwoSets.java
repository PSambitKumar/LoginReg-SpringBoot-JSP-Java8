package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.Collections;
import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 11/10/2022 - 3:32 PM
 */
public class BetweenTwoSets {
	public static int getTotalX(List<Integer> a, List<Integer> b){
		int count = 0;
		int max = Collections.max(a);
		int min = Collections.min(b);
		for (int i = max; i <= min; i++) {
			if (isFactor(i, a) && isMultiple(i, b)) {
				count++;
			}
		}
		return count;
	}

	public static boolean isFactor(int num, List<Integer> a){
		for (Integer integer : a) {
			if (num % integer != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isMultiple(int num, List<Integer> b){
		for (Integer integer : b) {
			if (integer % num != 0) {
				return false;
			}
		}
		return true;
	}
}
