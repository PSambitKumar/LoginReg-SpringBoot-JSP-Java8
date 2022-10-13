package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.*;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 10:30 PM
 */
public class LongestSubArray {

	public static int longestSubArray(List<Integer> arr){
		int i, j, max = 1;
		List<Integer> set = new ArrayList<>();
		for (i = 0; i < arr.size() -1; i++){
			set.add(arr.get(i));
			for (j = i + 1; j < arr.size(); j++){
				if (Math.abs(arr.get(i) - arr.get(j)) == 0 || Math.abs(arr.get(i) - arr.get(j)) == 1) {
					if (!set.contains(arr.get(j))) {
						if (set.size() == 2){
							break;
						}else {
							set.add(arr.get(j));
						}
					}
				}else {
					break;
				}
			}
			if (set.size() ==  2){
				max = Math.max(max, j-i);
				set.clear();
			}else {
				set.clear();
			}
		}
		return max;
	}

	public static int longestSubarray(int[] arr) {
		int i, j, max = 1;
		HashSet<Integer> s = new HashSet<>();
		for(i = 0; i < arr.length - 1; i++) {
			s.add(arr[i]);
			for(j = i + 1; j < arr.length; j++) {
				if (Math.abs(arr[i] - arr[j]) == 0 || Math.abs(arr[i] - arr[j]) == 1) {
					if (!s.contains(arr[j])) {
						if (s.size() == 2)
							break;
						else
							s.add(arr[j]);
					}
				}
				else
					break;
			}
			if (s.size() == 2) {
				max = Math.max(max, j - i);
				s.clear();
			}
			else
				s.clear();
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestSubarray(new int[]{0, 1, 1, 2, 2, 3}));
		System.out.println(longestSubArray(List.of(4, 4, 4, 5, 5, 4, 5)));
	}

}
