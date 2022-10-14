package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 11:27 AM
 */
public class JavaStringTokens {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		if (s.trim().length() == 0) {
			System.out.println(0);
		} else {
			String[] tokens = s.trim().split("[ !,?._'@]+");
			System.out.println(tokens.length);
			for (String token : tokens) {
				System.out.println(token);
			}
		}
		scan.close();
	}
}
