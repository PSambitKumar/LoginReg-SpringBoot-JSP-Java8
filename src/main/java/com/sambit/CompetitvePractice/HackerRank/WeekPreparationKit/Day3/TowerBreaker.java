package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day3;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 15/10/2022 - 10:08 AM
 */
public class TowerBreaker {
	public static void main(String[] args) {
	   System.out.println(towerBreakers(2, 2));
    }

    static int towerBreakers(int n, int m) {
	   if (m == 1) {
		  return 2;
	   }
	   if (n % 2 == 0) {
		  return 2;
	   }
	   return 1;
    }
}
