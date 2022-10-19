package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 19/10/2022 - 10:58 AM
 */
public class BillDivision {
	static  void bonAppetit(List<Integer> bill, int k, int b) {
		int sum = 0;
		for (int i = 0; i < bill.size(); i++) {
			if (i != k) {
				sum += bill.get(i);
			}
		}
		if (sum / 2 == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - sum / 2);
		}
	}

    static void bonAppetit(int[] bill, int k, int b) {
	   int sum = 0;
	   for (int i = 0; i < bill.length; i++) {
		  if (i != k) {
			 sum += bill[i];
		  }
	   }
	   if (sum / 2 == b) {
		  System.out.println("Bon Appetit");
	   } else {
		  System.out.println(b - (sum / 2));
	   }
    }

    public static void main(String[] args) {
	   bonAppetit(new int[]{3, 10, 2, 9}, 1, 12);
	   bonAppetit(List.of(3, 10, 2, 9), 1, 12);
    }
}
