package com.sambit.CompetitvePractice.HackerRank.Certification.JavaBasic;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 28/10/2022 - 12:05 PM
 */

public class MultiSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

		if (s.matches(".*\\d.*")) {
			String[] s1 = s.split(" ");
			int sum = 0;
			for (String value : s1) {
				if (value.matches("[0-9]+")) {
					sum += Integer.parseInt(value);
				}
			}
			System.out.println(sum);
		} else {
			System.out.println(s.replace(" ", ""));
		}
	}
}
