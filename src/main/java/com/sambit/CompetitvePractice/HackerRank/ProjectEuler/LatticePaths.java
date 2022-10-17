package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 17/10/2022 - 6:38 PM
 */
public class LatticePaths {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int i =0;i<T;i++)
		{
			int N=sc.nextInt();
			int M=sc.nextInt();
			BigInteger path = fact(BigInteger.valueOf(N+M)) .divide(fact(BigInteger.valueOf(N))) .divide(fact(BigInteger.valueOf(M))) .mod((BigInteger.valueOf(1000000007)));
			System.out.println(path.toString());

		}
		sc.close();
	}
	static BigInteger fact(BigInteger num)
	{
		if (Objects.equals(num, BigInteger.ZERO))
			return BigInteger.ONE;

		return num.multiply(fact(num.subtract(BigInteger.ONE )));
	}


}