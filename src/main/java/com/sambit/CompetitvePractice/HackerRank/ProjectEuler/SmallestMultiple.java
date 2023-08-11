package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 8:54 PM
 */
public class SmallestMultiple {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			long lcm = 1;
			for (int i = 1; i <= n; i++) {
				lcm = lcm(lcm, i);
			}
			System.out.println(lcm);
		}
	}

	private static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
