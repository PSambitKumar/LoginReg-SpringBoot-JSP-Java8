package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 12/11/2022 - 9:54 PM
 **/
public class LetsReview {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			String s = scanner.next();
			for (int j = 0; j < s.length(); j++) {
				if (j % 2 == 0) {
					System.out.print(s.charAt(j));
				}
			}
			System.out.print(" ");
			for (int j = 0; j < s.length(); j++) {
				if (j % 2 != 0) {
					System.out.print(s.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
