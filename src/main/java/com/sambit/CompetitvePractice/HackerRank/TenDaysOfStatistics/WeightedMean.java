package com.sambit.CompetitvePractice.HackerRank.TenDaysOfStatistics;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 06/11/2022 - 10:18 PM
 */
public class WeightedMean {

	public static void weightedMean(List<Integer> X, List<Integer> W){
		int sum = 0;
		int sumW = 0;
		for (int i=0;i<X.size();i++){
			sum += X.get(i)*W.get(i);
			sumW += W.get(i);
		}
		System.out.printf("%.1f%n",(double)sum/sumW);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> X = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> W = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		weightedMean(X,W);
	}


	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n];
		int[] weight = new int[n];
		int sum = 0;
		for (int i=0;i<n;i++){
			arr[i] = sc.nextInt();
			sum+= arr[i];
		}
		for (int i=0;i<n;i++){
			weight[i] = sc.nextInt();
		}
		int sum1 = 0;
		for (int i=0;i<n;i++){
			sum1+= arr[i]*weight[i];
		}
		System.out.printf("%.1f%n",(double)sum1/sum);
	}
}
