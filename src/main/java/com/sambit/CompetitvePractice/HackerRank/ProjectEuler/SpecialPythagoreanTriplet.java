package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 3:59 PM
 */
public class SpecialPythagoreanTriplet {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		for(int a0 = 0; a0 < t; a0++){
//			int n = in.nextInt();
//			int max = -1;
//			for (int i = 1; i < n; i++) {
//				for (int j = i + 1; j < n; j++) {
//					int k = n - i - j;
//					if (i * i + j * j == k * k) {
//						max = Math.max(max, i * j * k);
//					}
//				}
//			}
//			System.out.println(max);
//		}
//	}

	public static void main(String[] args) {
		int maxPerimeter = 3000;
		int noSolution = -1;
		int[] cache = new int[maxPerimeter + 1];
		Arrays.fill(cache, noSolution);

		for (int a = 1; a < maxPerimeter; a++) {
			for (int b = a + 1; b < maxPerimeter - a; b++) {
				int c2 = a * a + b * b;
				int c = (int) Math.sqrt(c2);
				if (c * c != c2) {
					continue;
				}
				int sum = a + b + c;
				if (sum > maxPerimeter) {
					break;
				}
				if (cache[sum] < a * b * c) {
					cache[sum] = a * b * c;
				}
			}
		}
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(cache[n]);
		}

	}
}
