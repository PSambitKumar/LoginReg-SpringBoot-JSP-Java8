package com.sambit.CompetitvePractice.HackerRank.TenDaysOfStatistics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 07/11/2022 - 9:10 AM
 */
public class Quartiles {
	public static List<Integer> quartiles(List<Integer> arr){
		List<Integer> result = new ArrayList<>();
		Collections.sort(arr);
		int n = arr.size();
		if (n%2==0){
			result.add(median(arr.subList(0,n/2)));
			result.add(median(arr));
			result.add(median(arr.subList(n/2,n)));
		}else{
			result.add(median(arr.subList(0,n/2)));
			result.add(median(arr));
			result.add(median(arr.subList(n/2+1,n)));
		}
		return result;
	}

	public static int median(List<Integer> arr){
		int n = arr.size();
		if (n%2==0){
			return (arr.get(n/2-1)+arr.get(n/2))/2;
		}else{
			return arr.get(n/2);
		}
	}

	public static void main(String[] args) {
		System.out.println(quartiles(List.of(3, 7, 8, 5, 12, 14, 21, 13, 18)));
	}
}
