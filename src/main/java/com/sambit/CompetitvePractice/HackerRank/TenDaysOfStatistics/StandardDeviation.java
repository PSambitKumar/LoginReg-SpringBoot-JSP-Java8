package com.sambit.CompetitvePractice.HackerRank.TenDaysOfStatistics;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 07/11/2022 - 9:43 AM
 */
public class StandardDeviation {
	public static void stdDev(List<Integer> arr){
//		double mean = arr.stream().mapToDouble(a -> a).average().orElse(0.0); Working
		double mean = mean(arr);
		double sum = 0;
		for (Integer value : arr) {
			sum += Math.pow(value - mean, 2);
		}
		System.out.println(Math.sqrt(sum / arr.size()));
	}

	public static double mean(List<Integer> arr){
		double sum = 0;
		for (Integer value : arr) {
			sum += value;
		}
		return sum/arr.size();
	}

	public static void main(String[] args) {
		stdDev(List.of(10, 40, 30, 50, 20));
	}
}
