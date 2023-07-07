package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 3:32 PM
 */
public class FirstPrime {
//	Method 1
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		for(int a0 = 0; a0 < t; a0++){
//			int n = in.nextInt();
//			int count = 0;
//			int i = 2;
//			while (count < n) {
//				if (isPrime(i)) {
//					count++;
//				}
//				i++;
//			}
//			System.out.println(i-1);
//		}
//	}
//
//	private static boolean isPrime(int i) {
//		if (i == 2) {
//			return true;
//		}
//		if (i % 2 == 0) {
//			return false;
//		}
//		for (int j = 3; j <= Math.sqrt(i); j+=2) {
//			if (i % j == 0) {
//				return false;
//			}
//		}
//		return true;
//	}


//	Method 2
//public static void main(String[] args) {
//	Scanner scanner = new Scanner(System.in);
//	int t = scanner.nextInt();
//	for (int i = 0; i < t; i++) {
//		int n = scanner.nextInt();
//		System.out.println(getNthPrime(n));
//	}
//}
//
//	public static int getNthPrime(int n){
//		int count = 0;
//		int i = 2;
//		while (count < n){
//			if (isPrime(i)){
//				count++;
//			}
//			i++;
//		}
//		return i-1;
//	}
//
//	public static boolean isPrime(int n){
//		if (n == 2){
//			return true;
//		}
//		if (n % 2 == 0){
//			return false;
//		}
//		for (int i = 3; i <= Math.sqrt(n); i+=2) {
//			if (n % i == 0){
//				return false;
//			}
//		}
//		return true;
//	}

//	Method 3/Final Answer
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	int[] arr=new int[10000];
	int index=0;
	for(int a0 = 0; a0 < t; a0++){
		int n = in.nextInt();
		for(int i=0;i<Integer.MAX_VALUE && index<10000;i++){
			if(isPrime(i)){
				arr[index++]=i;
			}
		}
		System.out.println(arr[n-1]);
	}
}
	static boolean isPrime (int n){
		if (n < 2){
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++){
			if (n % i == 0){
				return false;
			}
		}
		return true;
	}
}

