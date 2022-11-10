package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/11/2022 - 9:34 PM
 */
public class IntroToConditionalStatements {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine().trim());

		if(N%2==1){
			System.out.println("Weird");
		}else if(N%2==0 && N>=2 && N<=5){
			System.out.println("Not Weird");
		}else if(N%2==0 && N>=6 && N<=20){
			System.out.println("Weird");
		}else if(N%2==0 && N>20){
			System.out.println("Not Weird");
		}

		bufferedReader.close();
	}
}
