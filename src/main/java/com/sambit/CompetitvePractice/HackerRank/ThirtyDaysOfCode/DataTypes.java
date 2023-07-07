package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 07/11/2022 - 9:05 AM
 */
public class DataTypes {
	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";
		int i1;
		double d1;
		String s1;
		Scanner scan = new Scanner(System.in);
		i1 = scan.nextInt();
		d1 = scan.nextDouble();
		scan.nextLine();
		s1 = scan.nextLine();
		System.out.println(i + i1);
		System.out.println(d + d1);
		System.out.println(s + s1);
		scan.close();
	}
}
