package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 -9:21 PM
 */
public class SumSquareDifference {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			long sumOfSquares = 0;
			long squareOfSum = 0;
			for (int i = 1; i <= n; i++) {
				sumOfSquares += i * i;
				squareOfSum += i;
			}
			squareOfSum *= squareOfSum;
			System.out.println(squareOfSum - sumOfSquares);
		}
	}
}
