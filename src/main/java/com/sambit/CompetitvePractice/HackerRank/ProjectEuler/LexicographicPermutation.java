package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 27/10/2022 - 11:36 AM
 */
public class LexicographicPermutation {
	private static final char c = 'm';
	private static final int array_length = c - 'a' + 1;
	private static final char[] cArray = new char[array_length];

	static {
		char ch = 'a';
		int i = 0;
		while (ch <= c) {
			cArray[i++] = ch++;
		}
	}

	private static String getResult(long n) {
		List<Integer> permutations = getPermutations(n);
		int size = permutations.size();
		char[] result = new char[array_length];
		int k = 0;
		for (int i = 0; i < array_length - size; i++) {
			result[k++] = cArray[i];
		}
		List<Character> listAffected = new ArrayList<>();
		for (int j = array_length - size; j < array_length; j++) {
			listAffected.add(cArray[j]);
		}
		for (int m = size - 1; m >= 0; m--) {
			int index = permutations.get(m);
			result[k++] = listAffected.remove(index);
		}
		return new String(result);
	}

	private static List<Integer> getPermutations(long n) {
		List<Integer> list = new ArrayList<>();
		int i = 1;
		while (true) {
			long quotient = n / i;
			long remainder = n % i;
			list.add((int)remainder);
			if (quotient == 0) {
				break;
			}
			n = quotient;
			i++;
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			long l = in.nextLong();
			System.out.println(getResult(l - 1));
		}
		in.close();
	}
}
