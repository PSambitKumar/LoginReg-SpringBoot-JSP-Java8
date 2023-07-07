package com.sambit.CompetitvePractice.HackerRank.InterviewPreparationKit.Arrays;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 3:56 PM
 */
public class ArrayDS {
		public static List<Integer> reverseArray(List<Integer> a){
			int i = 0;
			int j = a.size() - 1;
			while(i < j){
				int temp = a.get(i);
				a.set(i, a.get(j));
				a.set(j, temp);
				i++;
				j--;
			}
			return a;
		}
}
