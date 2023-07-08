package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 11/10/2022 - 11:32 PM
 */
public class JavaOutputFormatting {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("================================");
		for(int i=0;i<3;i++){
			String s1=sc.next();
			int x=sc.nextInt();
			System.out.printf("%-15s%03d%n",s1,x);
		}
		System.out.println("================================");

	}
}
