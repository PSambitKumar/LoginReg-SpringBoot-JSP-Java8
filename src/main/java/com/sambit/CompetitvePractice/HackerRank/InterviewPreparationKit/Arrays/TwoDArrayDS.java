package com.sambit.CompetitvePractice.HackerRank.InterviewPreparationKit.Arrays;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 11:41 AM
 */
public class TwoDArrayDS {
	public static int hourglassSum(List<List<Integer>> arr){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.size() - 2; i++){
			for (int j = 0; j < arr.get(i).size() - 2; j++){
				int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
				if (sum > max){
					max = sum;
				}
			}
		}
		return max;
	}

	public static int hourglassSum(int[][] arr){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 2; i++){
			for (int j = 0; j < arr[i].length - 2; j++){
				int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (sum > max){
					max = sum;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
//		Using Of List
		System.out.println(hourglassSum(List.of(
			   List.of(1, 1, 1, 0, 0, 0),
			   List.of(0, 1, 0, 0, 0, 0),
			   List.of(1, 1, 1, 0, 0, 0),
			   List.of(0, 0, 2, 4, 4, 0),
			   List.of(0, 0, 0, 2, 0, 0),
			   List.of(0, 0, 1, 2, 4, 0)
		)));

//		Using Of Array
		System.out.println(hourglassSum(new int[][]{
			   {1, 1, 1, 0, 0, 0},
			   {0, 1, 0, 0, 0, 0},
			   {1, 1, 1, 0, 0, 0},
			   {0, 0, 2, 4, 4, 0},
			   {0, 0, 0, 2, 0, 0},
			   {0, 0, 1, 2, 4, 0}
		}));
	}
}
