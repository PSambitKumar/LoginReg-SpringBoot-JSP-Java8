package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Week2;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 10:35 AM
 */
public class FlippingTheMatrix {
	public static int flippingMatrix(List<List<Integer>> matrix){
		int result = 0;
		for (int i = 0; i < matrix.size() / 2; i++) {
			for (int j = 0; j < matrix.size() / 2; j++) {
				result += Math.max(Math.max(matrix.get(i).get(j), matrix.get(i).get(matrix.size() - j - 1)),
						Math.max(matrix.get(matrix.size() - i - 1).get(j), matrix.get(matrix.size() - i - 1).get(matrix.size() - j - 1)));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(flippingMatrix(List.of(List.of(112, 42, 83, 119), List.of(56, 125, 56, 49), List.of(15, 78, 101, 43), List.of(62, 98, 114, 108))));
	}
}
