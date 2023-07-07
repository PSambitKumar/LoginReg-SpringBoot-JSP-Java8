package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 16/11/2022 - 9:36 AM
 */
public class BinaryNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int max = 0;
		int count = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				count++;
				if (count > max) {
					max = count;
				}
			} else {
				count = 0;
			}
			n /= 2;
		}
		System.out.println(max);

		bufferedReader.close();
	}
}
