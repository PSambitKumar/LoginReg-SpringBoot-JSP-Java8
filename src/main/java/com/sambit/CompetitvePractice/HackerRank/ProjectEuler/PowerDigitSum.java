package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 17/10/2022 - 8:22 PM
 */
public class PowerDigitSum {
	public static void main(String args[])
	{
		Scanner sc = new Scanner (System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			int n=sc.nextInt();

			BigInteger A = BigInteger.valueOf(2);
			BigInteger b=A.pow(n);
			System.out.println(Sum(b));
		}
		sc.close();
	}
	public static long Sum(BigInteger num)
	{
		long sum=0;
		String st = num.toString();

		for(int i=0;i<st.length();i++)
		{
			sum+=Long.parseLong(Character.toString(st.charAt(i)));
		}
		return sum;
	}
}
