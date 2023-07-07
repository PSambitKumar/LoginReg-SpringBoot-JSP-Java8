package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 01/11/2022 - 10:21 AM
 */
public class JavaMap {
	public static void main(String[] args) {
		Map<String, Integer> phoneBook = new HashMap<>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			phoneBook.put(name, phone);
			in.nextLine();
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			if (phoneBook.containsKey(s)) {
				System.out.println(s + "=" + phoneBook.get(s));
			} else {
				System.out.println("Not found");
			}
		}
	}
}
