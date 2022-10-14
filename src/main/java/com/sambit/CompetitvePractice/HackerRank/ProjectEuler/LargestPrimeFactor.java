package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 7:30 PM
 */
public class LargestPrimeFactor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			long n = in.nextLong();
			long maxPrime = -1;
			while (n % 2 == 0) {
				maxPrime = 2;
				n >>= 1;
			}
			for (int i = 3; i <= Math.sqrt(n); i += 2) {
				while (n % i == 0) {
					maxPrime = i;
					n = n / i;
				}
			}
			if (n > 2)
				maxPrime = n;
			System.out.println(maxPrime);
		}
	}
}
