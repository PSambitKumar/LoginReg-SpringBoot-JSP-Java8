package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 27/10/2022 - 3:51 PM
 */
public class NDigitFibonacciNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 1);
		for (int i = 3; i <= 5000; i++) {
			map.put(i, (map.get(i - 1) + map.get(i - 2)) % 1000000000);
		}
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			for (int i = 1; i <= 5000; i++) {
				if (map.get(i).toString().length() == n) {
					System.out.println(i);
					break;
				}
			}
		}
	}

//	Two Test Case Wrong Answer
	public static void main3(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 1);
		for (int i = 3; i <= 5000; i++) {
			map.put(i, map.get(i - 1) + map.get(i - 2));
		}
		while (t --> 0) {
			int n = in.nextInt();
			for (int i = 1; i <= 5000; i++) {
				if (map.get(i).toString().length() == n) {
					System.out.println(i);
					break;
				}
			}
		}
		in.close();
	}

//	Two Test Cases are failing. Need to fix it.
	public static void main2(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int a0 = in.nextInt();
			System.out.println(getResult( a0));
		}
	}

	private static int getResult(int a0) {
		int a = 1;
		int b = 1;
		int c = 0;
		int count = 2;
		while (true) {
			c = a + b;
			a = b;
			b = c;
			count++;
			if (c >= Math.pow(10, a0 - 1)) {
				return count;
			}
		}
	}

//	Time Limit Exceeded(Two Test Cases Failed)
	public static void main1(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int a = 1;
			int b = 1;
			int c;
			int count = 2;
			while (true) {
				c = a + b;
				count++;
				if (c >= Math.pow(10, n - 1)) {
					break;
				}
				a = b;
				b = c;
			}
			System.out.println(count);
		}
	}
}