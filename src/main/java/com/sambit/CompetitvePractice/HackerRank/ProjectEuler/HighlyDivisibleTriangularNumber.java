package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Map;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 16/10/2022 - 1:13 AM
 */
public class HighlyDivisibleTriangularNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int i = 1;
			int sum = 0;
			while (true) {
				sum += i;
				int count = 0;
				for (int j = 1; j <= Math.sqrt(sum); j++) {
					if (sum % j == 0) {
						if (sum / j == j)
							count++;
						else
							count += 2;
					}
				}
				if (count > n) {
					System.out.println(sum);
					break;
				}
				i++;
			}
		}
	}
}
