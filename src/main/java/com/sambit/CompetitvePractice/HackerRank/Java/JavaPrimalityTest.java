package com.sambit.CompetitvePractice.HackerRank.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 21/10/2022 - 11:44 AM
 */
public class JavaPrimalityTest {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String n = bufferedReader.readLine();
		BigInteger y = new BigInteger(n);
		if(y.isProbablePrime(1)){
			System.out.println("prime");
		}else{
			System.out.println("not prime");
		}
		bufferedReader.close();
	}
}
