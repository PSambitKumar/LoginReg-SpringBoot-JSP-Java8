package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 15/11/2022 - 6:08 PM
 */
public class DigitNthPowers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int sum = 0;
		for (int j = 2; j < 1000000; j++) {
			int temp = j;
			int tempSum = 0;
			while (temp > 0) {
				tempSum += Math.pow(temp % 10, t);
				temp /= 10;
			}
			if (tempSum == j) {
				sum += j;
			}
		}
		System.out.println(sum);
	}
}
