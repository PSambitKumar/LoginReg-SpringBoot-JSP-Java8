package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 11:29 AM
 */
public class PatternSyntaxChecker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String pattern = in.nextLine();
			try {
				java.util.regex.Pattern.compile(pattern);
				System.out.println("Valid");
			} catch (Exception e) {
				System.out.println("Invalid");
			}
			testCases--;
		}
	}
}
