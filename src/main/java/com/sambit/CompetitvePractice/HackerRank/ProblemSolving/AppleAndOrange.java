package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 11/10/2022 - 11:04 AM
 */
public class AppleAndOrange {

	static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
		int appleCount = 0;
		int orangeCount = 0;
		for (Integer apple : apples) {
			if (apple + a >= s && apple + a <= t) {
				appleCount++;
			}
		}
		for (Integer orange : oranges) {
			if (orange + b >= s && orange + b <= t) {
				orangeCount++;
			}
		}
		System.out.println(appleCount);
		System.out.println(orangeCount);
	}


    public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
	   int appleCount = 0;
	   int orangeCount = 0;
	   for (int apple : apples) {
		  if (apple + a >= s && apple + a <= t) {
			 appleCount++;
		  }
	   }
	   for (int orange : oranges) {
		  if (orange + b >= s && orange + b <= t) {
			 orangeCount++;
		  }
	   }
	   System.out.println(appleCount);
	   System.out.println(orangeCount);
    }
}
