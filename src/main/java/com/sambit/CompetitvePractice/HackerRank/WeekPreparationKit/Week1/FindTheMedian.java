package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Week1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 11:03 PM
 */
public class FindTheMedian {
	public static int findMedian(List<Integer> arr){
		int median;
		int[] array = new int[arr.size()];

//		for (Integer data : arr) {
//			array[arr.indexOf(data)] = data;
//		}
		for (int i = 0; i < arr.size(); i++) {
			array[i] = arr.get(i);
		}


//		Sorting An Array Method 1(Using Predefined Funtion)
		Arrays.sort(array);

//		Sorting An Array Method 2
//		for (int i = 0; i < array.length; i++) {
//			for (int j = i + 1; j < array.length; j++) {
//				if (array[i] > array[j]) {
//					int temp = array[i];
//					array[i] = array[j];
//					array[j] = temp;
//				}
//			}
//		}
		median = array[array.length/2];
		return median;
	}

		public static int findTheMedian(int[] arr){
		int median = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		median = arr[arr.length/2];
		return median;
	}

	public static void main(String[] args) {
		System.out.println(findMedian(List.of(0,1,2,4,6,5,3)));
	}

}
