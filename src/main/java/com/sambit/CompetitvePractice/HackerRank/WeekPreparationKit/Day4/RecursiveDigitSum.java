package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day4;

import org.apache.poi.openxml4j.opc.internal.unmarshallers.PackagePropertiesUnmarshaller;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 16/10/2022 - 10:37 AM
 */
public class RecursiveDigitSum {

//	Two Test Case Not Passing(Test Case 7, 8)
	public static int superDigit(String n, int k){
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			sum += n.charAt(i) - '0';
		}
		sum *= k;
		return superDigit(String.valueOf(sum));
	}

	public static int superDigit(String n){
		if (n.length() == 1) {
			return Integer.parseInt(n);
		}
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			sum += n.charAt(i) - '0';
		}
		return superDigit(String.valueOf(sum));
	}

//	3 Test Case Not Passing(7,8,9)
//	public static int superDigit(String n, int k) {
//		int sum = 0;
//		for (int i = 0; i < n.length(); i++) {
//			sum += n.charAt(i) - '0';
//		}
//		sum *= k;
//		while (sum > 9) {
//			int temp = sum;
//			sum = 0;
//			while (temp > 0) {
//				sum += temp % 10;
//				temp /= 10;
//			}
//		}
//		return sum;
//	}

//	3 Test Case Not Passing(7,8,9)
//	public static int superDigit(String n, int k) {
//		int sum = 0;
//		for (int i = 0; i < n.length(); i++) {
//			sum += n.charAt(i) - '0';
//		}
//		sum *= k;
//		while (sum > 9) {
//			sum = sum % 9;
//		}
//		return sum == 0 ? 9 : sum;
//	}

//	public static int superDigit(String n, int k) {
//		int sum = 0;
//		for (int i = 0; i < n.length(); i++) {
//			sum += n.charAt(i) - '0';
//		}
//		sum *= k;
//		return superDigit(String.valueOf(sum));
//	}
//
//	public static int superDigit(String n) {
//		if (n.length() == 1) {
//			return Integer.parseInt(n);
//		}
//		int sum = 0;
//		for (int i = 0; i < n.length(); i++) {
//			sum += n.charAt(i) - '0';
//		}
//		return superDigit(String.valueOf(sum));
//	}

}


