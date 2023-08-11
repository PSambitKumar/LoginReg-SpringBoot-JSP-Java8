package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 22/10/2022 - 10:25 AM
 */
public class BigInteger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		java.math.BigInteger a = sc.nextBigInteger();
		java.math.BigInteger b = sc.nextBigInteger();
		System.out.println(a.add(b));
		System.out.println(a.multiply(b));
	}
}
