package com.sambit.CompetitvePractice.HackerRank.TenDaysOfStatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 07/11/2022 - 10:26 AM
 */
public class InterQuartileRange {
	public static void interQuartile(List<Integer> values, List<Integer> freqs){
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < freqs.get(i); j++) {
				arr.add(values.get(i));
			}
		}
		Collections.sort(arr);
		int n = arr.size();
		if (n%2==0){
			System.out.println(InterQuartileRange.median(arr.subList(n/2,n))-Quartiles.median(arr.subList(0,n/2)));
		}else{
			System.out.println(InterQuartileRange.median(arr.subList(n/2+1,n))-Quartiles.median(arr.subList(0,n/2)));
		}
	}

	public static Double median(List<Integer> arr){
		int n = arr.size();
		if (n%2==0){
			return (double)(arr.get(n/2-1)+arr.get(n/2))/2;
		}else{
			return (double)arr.get(n/2);
		}
	}

	public static void main(String[] args) {
		interQuartile(List.of(6, 12, 8, 10, 20, 16), List.of(5, 4, 3, 2, 1, 5));
	}
}
