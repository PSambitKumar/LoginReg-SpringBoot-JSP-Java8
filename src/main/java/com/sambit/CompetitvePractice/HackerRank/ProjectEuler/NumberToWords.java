package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 18/10/2022 - 12:25 PM
 */


public class NumberToWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] arr = new int[t];

		for (int i = 0; i < t; i++) {
			arr[i] = in.nextInt();
		}

		helper1(arr, t);

	}

	public static void helper1(int[] arr, int t){
		for (int a0 = 0; a0 < t; a0++) {
			String[] thousands = {"", "Thousand", "Million", "Billion"};
			String result = "";
			int n = arr[a0];
			if (n == 0) {
				result = "Zero";
			} else {
				int i = 0;
				while (n > 0) {
					if (n % 1000 != 0) {
						result = helper2((int) (n % 1000)) + thousands[i] + " " + result;
					}
					n /= 1000;
					i++;
				}
			}
			System.out.println(result.trim());
		}
	}

	public static String helper2(int n) {
		String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String result = "";
		if (n < 20) {
			result = ones[n];
		} else if (n < 100) {
			result = tens[n / 10] + " " + ones[n % 10];
		} else {
			result = ones[n / 100] + " Hundred " + helper2(n % 100);
		}
		return result;
	}
}
