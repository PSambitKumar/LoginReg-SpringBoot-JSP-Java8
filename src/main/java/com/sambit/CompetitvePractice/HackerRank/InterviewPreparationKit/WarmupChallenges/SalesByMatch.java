package com.sambit.CompetitvePractice.HackerRank.InterviewPreparationKit.WarmupChallenges;

import java.util.List;
import java.util.Objects;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 10:00 AM
 */
public class SalesByMatch {
//	Question : There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

	public static int stockMerchant(int n, List<Integer> ar){
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (Objects.equals(ar.get(i), ar.get(j))){
					count++;
					ar.remove(j);
					n--;
					break;
				}
			}
		}
		return count;
	}

	public static int stockMerchant(int n, int[] ar){
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (ar[i] == ar[j]){
					count++;
					ar[j] = 0;
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

//		Using Of List
		System.out.println(stockMerchant(9, List.of(10, 20, 20, 10, 10, 30, 50, 10, 20)));

//		Using Of Array
		System.out.println(stockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));

//		Using of Array
//		int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
//		System.out.println(stockMerchant(ar.length, ar));


	}
}
