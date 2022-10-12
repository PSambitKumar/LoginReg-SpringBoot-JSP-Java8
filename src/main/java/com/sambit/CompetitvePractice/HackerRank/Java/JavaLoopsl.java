package com.sambit.CompetitvePractice.HackerRank.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 11/10/2022 - 11:42 PM
 */
public class JavaLoopsl {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		input.close();
		int a;
		for (a=0 ; a < 11 ; a++){
			System.out.println(N + " x " + "1 " + "= " + N*1);
			System.out.println(N + " x " + "2 " + "= " + N*2);
			System.out.println(N + " x " + "3 " + "= " + N*3);
			System.out.println(N + " x " + "4 " + "= " + N*4);
			System.out.println(N + " x " + "5 " + "= " + N*5);
			System.out.println(N + " x " + "6 " + "= " + N*6);
			System.out.println(N + " x " + "7 " + "= " + N*7);
			System.out.println(N + " x " + "8 "  + "= " + N*8);
			System.out.println(N + " x " + "9 "  + "= " + N*9);
			System.out.println(N + " x " + "10" + " = " + N*10);
			break;
		}
	}
}
