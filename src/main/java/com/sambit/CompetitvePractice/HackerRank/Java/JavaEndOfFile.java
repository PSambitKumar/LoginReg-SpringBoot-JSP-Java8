package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 3:00 PM
 */
public class JavaEndOfFile {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 1;
		while (scan.hasNext()) {
			System.out.println(i + " " + scan.nextLine());
			i++;
		}
		scan.close();
	}
}
