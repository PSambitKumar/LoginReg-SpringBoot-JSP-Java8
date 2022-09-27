package com.sambit.CompetitvePractice.Algorithms;

import java.util.Arrays;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 27/09/2022 - 5:49 PM
 */
public class Sorting {

//	Sorting Using sort()
	public static int[] sort(int[] arr, int n) {
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Bubble Sort
	public static int[] bubbleSort(int[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

//	Sorting Array Using Selection Sort
	public static int[] selectionSort(int[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}
}
