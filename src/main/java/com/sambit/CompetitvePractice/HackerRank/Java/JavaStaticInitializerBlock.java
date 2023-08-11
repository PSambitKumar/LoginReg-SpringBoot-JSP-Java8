package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 10:55 AM
 */
public class JavaStaticInitializerBlock {

//	Method 1
//    static int B;
//    static int H;
//    static boolean flag = true;
//
//    static {
//	   Scanner scanner = new Scanner(System.in);
//	   B = scanner.nextInt();
//	   H = scanner.nextInt();
//	   if (B <= 0 || H <= 0) {
//		  System.out.println("java.lang.Exception: Breadth and height must be positive");
//		  flag = false;
//	   }
//    }
//
//    public static void main(String[] args) {
//	   if (flag) {
//		  int area = B * H;
//		  System.out.print(area);
//	   }
//    }


//	Method 2
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int B = in.nextInt();
		int H = in.nextInt();
		if (B <= 0 || H <= 0) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		} else {
			int area = B * H;
			System.out.println(area);
		}
	}
}
