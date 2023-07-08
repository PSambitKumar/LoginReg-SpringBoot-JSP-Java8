package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 7:51 PM
 */
public class LargestPalindromeProduct {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int max = -1;
			for (int i = 100; i < 1000; i++) {
				for (int j = 100; j < 1000; j++) {
					int product = i * j;
					if (product < n && isPalindrome(product) && product > max) {
						max = product;
					}
				}
			}
			System.out.println(max);
		}
	}

	private static boolean isPalindrome(int n) {
		int reverse = 0;
		int temp = n;
		while (temp != 0) {
			reverse = reverse * 10 + temp % 10;
			temp /= 10;
		}
		return reverse == n;
	}
}
