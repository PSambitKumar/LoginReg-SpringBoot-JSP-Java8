package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 4:04 PM
 */
public class LargeSum {
//	Method 1
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		System.out.println(t);
//		String[] arr = new String[t];
//		long sum = 0;
//		for(int i = 0; i < t; i++){
//			Long num = in.nextLong();
//			String str = num.toString();
//			if (str.length() > 10) {
//				str = str.substring(0, 10);
//				arr[i] = str;
//			}
//		}
//		for (int i = 0; i < t; i++) {
//			sum += Long.parseLong(arr[i]);
//		}
//		System.out.println(sum);
//	}

//	Method 2
//	public static void main(String[] args) {
//		int x = new Scanner(System.in).nextInt();
//		long sum = 0;
//		Long[] arr = new Long[x];
//		for (int i = 0; i < x; i++) {
//			arr[i] = new Scanner(System.in).nextLong();
//		}
//
////		Take First 10 digits of each number and add them
//		for (int i = 0; i < x; i++) {
//			sum += arr[i] / 10000000000L;
//		}
//		System.out.println(sum);
//	}


//	public static void main(String[] args) {
//		int x = new Scanner(System.in).nextInt();
//		long sum = 0;
//		String[] arr = new String[x];
//		for (int i = 0; i < x; i++) {
//			arr[i] = new Scanner(System.in).next();
//		}
//		for (String s : arr) {
//			sum += Long.parseLong(s.substring(0, 10));
//		}
//		System.out.println(sum);
//	}


//	public static void main(String[] args) {
//		int x = new Scanner(System.in).nextInt();
//		long sum = 0;
//		String[] arr = new String[x];
//		for (int i = 0; i < x; i++) {
//			sum += Long.parseLong((new Scanner(System.in).next()).substring(0, 9));
//		}
//		System.out.println(sum);
//	}

//	Final Answer
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.next();
		}

		int carry = 0;
		String sum = "";

		for (int i = 49; i >= 0; i--) {
			int temp = carry;
			for (int j = 0; j < n; j++) {
				temp += Integer.parseInt(arr[j].substring(i, i + 1));
			}
			sum = temp % 10 + sum;
			carry = temp / 10;
		}
		System.out.println((carry + sum).substring(0, 10));
	}

}
