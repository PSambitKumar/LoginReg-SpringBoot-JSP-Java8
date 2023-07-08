

package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
    *@Project : Registration
    *@Author : Sambit Kumar Pradhan
    *@Created On : 28/10/2022 - 1:08 PM
*/public class ReciprocalCycles {
	int cycleLength(int n) {
		int[] remainders = new int[n];
		int value = 1;
		int position = 0;
		while (remainders[value] == 0 && value != 0) {
			remainders[value] = position;
			value *= 10;
			value %= n;
			position++;
		}
		return position - remainders[value];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		ReciprocalCycles rc = new ReciprocalCycles();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int maxCycleLength = 0;
			int maxCycleLengthNumber = 0;
			for (int i = 2; i < n; i++) {
				int cycleLength = rc.cycleLength(i);
				if (cycleLength > maxCycleLength) {
					maxCycleLength = cycleLength;
					maxCycleLengthNumber = i;
				}
			}
			System.out.println(maxCycleLengthNumber);
		}
	}
}
