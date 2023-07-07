package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/11/2022 - 9:37 AM
 */
public class Arrays {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			   .map(Integer::parseInt)
			   .collect(toList());

		for (int i = arr.size() - 1; i >= 0; i--) {
			System.out.print(arr.get(i) + " ");
		}

		bufferedReader.close();
	}
}
