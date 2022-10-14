package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 11:24 AM
 */
public class JavaStringIntroduction {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String A=sc.next();
		String B=sc.next();

		System.out.println(A.length() + B.length());
		System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
		System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase() + B.substring(1));
	}
}
