package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 24/10/2022 - 7:50 PM
 */
public class FactorialDigitSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int sum = 0;
			int[] arr = new int[1000];
			arr[0] = 1;
			int len = 1;
			for (int i = 2; i <= n; i++) {
				len = multiply(i, arr, len);
			}
			for (int i = 0; i < len; i++) {
				sum += arr[i];
			}
			System.out.println(sum);
		}
	}

	public static int multiply(int x, int[] arr, int len) {
		int carry = 0;
		for (int i = 0; i < len; i++) {
			int prod = arr[i] * x + carry;
			arr[i] = prod % 10;
			carry = prod / 10;
		}
		while (carry != 0) {
			arr[len] = carry % 10;
			carry = carry / 10;
			len++;
		}
		return len;
	}
}
