package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 20/10/2022 - 12:08 PM
 */
public class JavaStringReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String reverse = new StringBuilder(A).reverse().toString();
		if (A.equals(reverse)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
