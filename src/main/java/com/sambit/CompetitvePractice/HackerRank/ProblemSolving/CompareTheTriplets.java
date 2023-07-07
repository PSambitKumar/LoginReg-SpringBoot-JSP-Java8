package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 8:05 PM
 */
public class CompareTheTriplets {
	public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		int alice = 0;
		int bob = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > b.get(i)){
				alice += 1;
			}else if (a.get(i) < b.get(i)){
				bob += 1;
			}
		}
		List<Integer> result = new ArrayList<>();
		result.add(alice);
		result.add(bob);
		return result;
	}
}
