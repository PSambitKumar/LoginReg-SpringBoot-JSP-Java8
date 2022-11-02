package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 02/11/2022 - 9:06 PM
 */
public class JavaHashSet {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		String [] pair_left = new String[t];
		String [] pair_right = new String[t];

		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
		}

		Set<String> list = new HashSet<>();

		for(int i = 0; i < t; i++){
			list.add(String.format("%s %s", pair_left[i], pair_right[i]));
			System.out.println(list.size());
		}

	}
}
