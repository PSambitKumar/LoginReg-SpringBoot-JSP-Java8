package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 31/10/2022 - 6:18 PM
 */
public class JavaList {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			String s = in.next();
			if (s.equals("Insert")) {
				int x = in.nextInt();
				int y = in.nextInt();
				int[] b = new int[n + 1];
				for (int j = 0; j < n + 1; j++) {
					if (j < x) {
						b[j] = a[j];
					} else if (j == x) {
						b[j] = y;
					} else {
						b[j] = a[j - 1];
					}
				}
				a = b;
				n++;
			} else {
				int x = in.nextInt();
				int[] b = new int[n - 1];
				for (int j = 0; j < n - 1; j++) {
					if (j < x) {
						b[j] = a[j];
					} else {
						b[j] = a[j + 1];
					}
				}
				a = b;
				n--;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
