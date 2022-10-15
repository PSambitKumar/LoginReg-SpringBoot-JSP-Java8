package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 16/10/2022 - 1:03 AM
 */
public class LargestProductInAGrid {
	public static void main(String[] args) {
		int size = 20;
		int[][] grid = new int[size][size];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		long max = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
//				For horizontal
				if (j + 3 < size) {
					long product = (long) grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
					max = Math.max(max, product);
				}
//				For vertical
				if (i + 3 < size) {
					long product = (long) grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j];
					max = Math.max(max, product);
				}
//				For diagonal
				if (i + 3 < size && j + 3 < size) {
					long product = (long) grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
					max = Math.max(max, product);
				}
//				For anti-diagonal
				if (i + 3 < size && j - 3 >= 0) {
					long product = (long) grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3];
					max = Math.max(max, product);
				}
			}
		}
		System.out.println(max);
	}
}

