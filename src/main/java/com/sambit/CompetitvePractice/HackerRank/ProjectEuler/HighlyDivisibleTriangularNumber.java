package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 16/10/2022 - 1:13 AM
 */
public class HighlyDivisibleTriangularNumber {
//	Method 1
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int t = scanner.nextInt();
//		for (int i = 0; i < t; i++) {
//			int n = scanner.nextInt();
//			System.out.println(getTriangularNumber(n));
//		}
//	}
//
//	public static long getTriangularNumber(int n) {
//		long sum = 0;
//		long i = 1;
//		while (true) {
//			sum += i;
//			if (getDivisors(sum) > n) {
//				return sum;
//			}
//			i++;
//		}
//	}
//
//	public static int getDivisors(long n) {
//		int count = 0;
//		for (long i = 1; i <= Math.sqrt(n); i++) {
//			if (n % i == 0) {
//				if (n / i == i) {
//					count++;
//				} else {
//					count += 2;
//				}
//			}
//		}
//		return count;
//	}

//	Method 2
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		for(int a0 = 0; a0 < t; a0++){
//			int n = in.nextInt();
//			int i = 1;
//			int sum = 0;
//			while (true) {
//				sum += i;
//				int count = 0;
//				for (int j = 1; j <= Math.sqrt(sum); j++) {
//					if (sum % j == 0) {
//						if (sum / j == j)
//							count++;
//						else
//							count += 2;
//					}
//				}
//				if (count > n) {
//					System.out.println(sum);
//					break;
//				}
//				i++;
//			}
//		}
//	}

//	Method 3
	public static int NrOfDivisors(int n){
		int d = 2, p, prod = 1;
		while (n > 1){
			p = 1;
			while (n % d == 0){
				n /= d;
				p++;
			}
			prod *= p;
			d++;
		}
		return prod;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int i = 1;
			int sum = 0;
			while (true) {
				sum += i;
				if (NrOfDivisors(sum) > n) {
					System.out.println(sum);
					break;
				}
				i++;
			}
		}
	}
}
