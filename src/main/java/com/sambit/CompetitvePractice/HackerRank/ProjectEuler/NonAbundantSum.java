package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 27/10/2022 - 10:17 AM
 */
public class NonAbundantSum {
	static int limit = 28123;

	static boolean[] abundant_numbers = new boolean[limit];
	static {
		for (int i = 1; i <= limit; i++) {
			if (i > 6 && i % 6 == 0) {
				abundant_numbers[i] = true;
			} else {
				int sum = foo(i);
				if (i < sum) {
					abundant_numbers[i] = true;
				}
			}
		}
	}

	private static int foo(int N) {
		int sum = 0;
		for (int i = 2; i * i < N; i++) {
			if (N % i == 0)
				sum += (i + N / i);
		}
		if (sum == 0)
			return sum;
		sum++;
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			if (a0 > limit) {
				System.out.println("YES");
			} else {
				if (getResult(a0)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
		in.close();
	}

	private static boolean getResult(int a0) {
		int i = (a0 + 1) / 2;
		for (int k = 1; k <= i; k++) {
			if (abundant_numbers[k] && abundant_numbers[a0 - k]) {
				return true;
			}
		}
		return false;
	}

}
