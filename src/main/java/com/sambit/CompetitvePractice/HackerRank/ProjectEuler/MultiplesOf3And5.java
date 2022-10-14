package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 5:09 PM
 */
public class MultiplesOf3And5 {

//	Time Complexity: (Execution Time is More)
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		for(int a0 = 0; a0 < t; a0++){
//			int n = in.nextInt();
//			long sum = 0;
//			for (int i = 1; i < n; i++) {
//				if (i % 3 == 0 || i % 5 == 0) {
//					sum += i;
//				}
//			}
//			System.out.println(sum);
//		}
//	}


//	Time Complexity: (Execution Time is Less)
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			long sum = 0;
			long sumOf3 = 0;
			long sumOf5 = 0;
			long sumOf15 = 0;
			long n3 = (n - 1) / 3;
			long n5 = (n - 1) / 5;
			long n15 = (n - 1) / 15;
			sumOf3 = 3 * n3 * (n3 + 1) / 2;
			sumOf5 = 5 * n5 * (n5 + 1) / 2;
			sumOf15 = 15 * n15 * (n15 + 1) / 2;
			sum = sumOf3 + sumOf5 - sumOf15;
			System.out.println(sum);
		}
	}


}
