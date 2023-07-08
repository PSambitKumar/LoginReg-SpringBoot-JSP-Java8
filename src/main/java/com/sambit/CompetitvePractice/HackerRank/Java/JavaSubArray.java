package com.sambit.CompetitvePractice.HackerRank.Java;

import org.springframework.http.HttpStatus;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 29/10/2022 - 10:03 PM
 */
public class JavaSubArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				if (sum < 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
