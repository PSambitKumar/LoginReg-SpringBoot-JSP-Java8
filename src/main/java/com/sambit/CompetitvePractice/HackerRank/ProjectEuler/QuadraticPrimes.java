package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 31/10/2022 - 9:22 AM
 */
public class QuadraticPrimes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int max = 0;
			int maxA = 0;
			int maxB = 0;
			for (int a = -n + 1; a < n; a++) {
				for (int b = -n; b <= n; b++) {
					int count = 0;
					for (int i = 0; i < n; i++) {
						int value = i * i + a * i + b;
						if (isPrime(value)) {
							count++;
						} else {
							break;
						}
					}
					if (count > max) {
						max = count;
						maxA = a;
						maxB = b;
					}
				}
			}
			System.out.println(maxA * maxB);
		}
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
