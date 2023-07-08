package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 3:49 PM
 */
public class LargestProductInASeries {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int k = in.nextInt();
			String num = in.next();
			long max = 0;
			for (int i = 0; i < n - k; i++) {
				long product = 1;
				for (int j = i; j < i + k; j++) {
					product *= num.charAt(j) - '0';
				}
				max = Math.max(max, product);
			}
			System.out.println(max);
		}
	}
}
