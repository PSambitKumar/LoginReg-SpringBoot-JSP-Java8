package com.sambit.CompetitvePractice.HackerRank.TenDaysOfStatistics;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 06/11/2022 - 10:13 PM
 */
public class MeanMedianMode {

//	Working
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n];
		int sum = 0;
		for (int i=0;i<n;i++){
			arr[i] = sc.nextInt();
			sum+= arr[i];
		}
		System.out.printf("%.1f%n",(double)sum/n);
		Arrays.sort(arr);
		System.out.printf("%.1f%n",(arr[n/2-1]+arr[n/2])/2.0);
		int max = 0, index = 0, count=0;
		for (int i = 0;i<n-1;i++){
			if (arr[i]==arr[i+1]){
				count++;
				if (max<count) {
					max = count;
					index = i;
				}
			} else count = 0;

		}
		System.out.println(arr[index]);
	}

	public static void main1(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		int sum = 0;
		for (int value : arr) {
			sum += value;
		}
		System.out.println((double) sum / arr.length);

		int[] arr1 = new int[arr.length];
		System.arraycopy(arr, 0, arr1, 0, arr.length);
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr1.length; j++) {
				if (arr1[i] > arr1[j]) {
					int temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
			}
		}
		if (arr1.length % 2 == 0) {
			System.out.println((double) (arr1[arr1.length / 2] + arr1[arr1.length / 2 - 1]) / 2);
		} else {
			System.out.println(arr1[arr1.length / 2]);
		}

		int[] arr2 = new int[arr.length];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		int max = 0;
		int maxCount = 0;
		for (int k : arr2) {
			int count = 0;
			for (int i : arr2) {
				if (k == i) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				max = k;
			}
		}
		System.out.println(max);
		in.close();
	}
}
