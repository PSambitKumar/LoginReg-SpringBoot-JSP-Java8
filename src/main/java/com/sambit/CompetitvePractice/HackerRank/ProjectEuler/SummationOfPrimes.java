

package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
    *@Project : Registration
    *@Author : Sambit Kumar Pradhan
    *@Created On : 14/10/2022 - 11:30 PM
*/public class SummationOfPrimes {

//	Time Limit Exceeded One Test Case Failed(But Working Fine in Local)
//    public static void main(String[] args) {
//	    Scanner in = new Scanner(System.in);
//	    int t = in.nextInt();
//	    for (int a0 = 0; a0 < t; a0++) {
//		    int n = in.nextInt();
//		    long sum = 0;
//		    boolean[] isPrime = new boolean[n + 1];
//		    for (int i = 2; i <= n; i++) {
//			    isPrime[i] = true;
//		    }
//		    for (int i = 2; i * i <= n; i++) {
//			    if (isPrime[i]) {
//				    for (int j = i; i * j <= n; j++) {
//					    isPrime[i * j] = false;
//				    }
//			    }
//		    }
//		    for (int i = 2; i <= n; i++) {
//			    if (isPrime[i]) {
//				    sum += i;
//			    }
//		    }
//		    System.out.println(sum);
//	    }
//    }


//	All Test Cases Passed/Final Answer
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		byte[] a = new byte[1_000_001];
		long[] out = new long[1_000_001];
		out[0] = 0;
		out[1] = 0;
		out[2] = 2;
		for (int i = 3; i <= 1000_000; i = i + 2) {
			if (a[i] == 0) {
				out[i]=out[i-1]+i;
				for (int j = i + i + i; j <= 1_000_000; j += i + i) {
					a[j] = 1;
				}
			}else {
				out[i]=out[i-1];
			}
			out[i+1]=out[i];
		}

		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(out[n]);
		}
	}
}
