package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 30/10/2022 - 9:16 PM
 */
public class JavaArraylist {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] a = new int[n][];
		for (int i = 0; i < n; i++) {
			int d = in.nextInt();
			a[i] = new int[d];
			for (int j = 0; j < d; j++) {
				a[i][j] = in.nextInt();
			}
		}
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			try {
				System.out.println(a[x - 1][y - 1]);
			} catch (Exception e) {
				System.out.println("ERROR!");
			}
		}
	}
}
