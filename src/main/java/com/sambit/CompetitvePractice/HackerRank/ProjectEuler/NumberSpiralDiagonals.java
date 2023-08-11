package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 16/11/2022 - 9:56 AM
 */
public class NumberSpiralDiagonals {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			long sum = 1;
			for (int i = 3; i <= n; i += 2) {
				sum += 4 * (i * i) - 6 * (i - 1);
			}
			System.out.println(sum);
		}
	}
}
