package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 6:14 PM
 */
public class EvenFibonacciNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			long n = sc.nextLong();
			long sum = 0;
			long a = 0;
			long b = 2;
			while (b < n) {
				sum += b;
				long c = 4 * b + a;
				a = b;
				b = c;
			}
			System.out.println(sum);
		}
	}
}

