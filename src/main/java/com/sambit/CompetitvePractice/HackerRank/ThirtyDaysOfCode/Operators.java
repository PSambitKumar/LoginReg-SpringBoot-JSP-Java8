package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 08/11/2022 - 9:12 AM
 */
public class Operators {
	public static void solve(double meal_cost, int tip_percent, int tax_percent){
		double tip = meal_cost * tip_percent / 100;
		double tax = meal_cost * tax_percent / 100;
		System.out.println(Math.round(meal_cost + tip + tax));
	}

	public static void main(String[] args) {
		solve(12.00, 20, 8);
	}
}
