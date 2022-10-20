package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 20/10/2022 - 11:37 AM
 */
public class MaximumPathSum1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int[][] arr = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k <= j; k++) {
					arr[j][k] = scanner.nextInt();
				}
			}
			System.out.println(maximumPathSum(arr));
		}
	}

	public static int maximumPathSum(int[][] arr) {
		int n = arr.length;
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
			}
		}
		return arr[0][0];
	}
}

