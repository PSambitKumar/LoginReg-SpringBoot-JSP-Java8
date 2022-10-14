package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 3:59 PM
 */
public class SpecialPythagoreanTriplet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int max = -1;
			for (int i = 1; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					int k = n - i - j;
					if (i * i + j * j == k * k) {
						max = Math.max(max, i * j * k);
					}
				}
			}
			System.out.println(max);
		}
	}
}
