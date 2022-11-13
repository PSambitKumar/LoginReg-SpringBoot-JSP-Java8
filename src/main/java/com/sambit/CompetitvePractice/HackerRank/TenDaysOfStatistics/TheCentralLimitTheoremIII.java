package com.sambit.CompetitvePractice.HackerRank.TenDaysOfStatistics;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 12/11/2022 - 9:51 PM
 */
public class TheCentralLimitTheoremIII {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double mean = scanner.nextDouble();
		double std = scanner.nextDouble();
		int n = scanner.nextInt();
		double z = scanner.nextDouble();
		double marginOfError = z * (std / Math.sqrt(n));
		System.out.println(mean - marginOfError);
		System.out.println(mean + marginOfError);
	}
}
