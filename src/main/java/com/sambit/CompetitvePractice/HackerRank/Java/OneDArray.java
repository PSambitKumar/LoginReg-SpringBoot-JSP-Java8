package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 23/10/2022 - 12:55 PM
 */
public class OneDArray {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}

		scan.close();

		// Prints each sequential element in array a
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
