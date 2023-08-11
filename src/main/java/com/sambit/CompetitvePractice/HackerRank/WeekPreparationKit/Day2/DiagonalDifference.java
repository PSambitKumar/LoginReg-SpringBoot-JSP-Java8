package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day2;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 9:35 AM
 */
public class DiagonalDifference {
	public static int diagonalDifference(List<List<Integer>> arr) {
		int leftDiagonal = 0;
		int rightDiagonal = 0;
		for (int i = 0; i < arr.size(); i++) {
			leftDiagonal += arr.get(i).get(i);
			rightDiagonal += arr.get(i).get(arr.size() - i - 1);
		}
		return Math.abs(leftDiagonal - rightDiagonal);
	}

	public static int diagonalDifference(int[] arr){
		int leftDiagonal = 0;
		int rightDiagonal = 0;
		for (int i = 0; i < arr.length; i++) {
			leftDiagonal += arr[i];
			rightDiagonal += arr[arr.length - i - 1];
		}
		return Math.abs(leftDiagonal - rightDiagonal);
	}

	public static void main(String[] args) {
		System.out.println(diagonalDifference(List.of(List.of(11, 2, 4), List.of(4, 5, 6), List.of(10, 8, -12))));
		System.out.println(diagonalDifference(new int[]{11, 2, 4, 4, 5, 6, 10, 8, -12}));
	}
}
