package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day7;

import java.util.List;
import java.util.TreeSet;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 18/10/2022 - 10:34 AM
 */
public class NoPrefixSet {
	public static void noPrefix(List<String> words){
		TreeSet<String> treeSet = new TreeSet<String>();
		for (String word : words) {

			if (treeSet.add(word)) {
				String nextElement = treeSet.higher(word);
				String prevElement = treeSet.lower(word);

				if (prevElement != null && word.startsWith(prevElement)) {
					System.out.println("BAD SET");
					System.out.println(word);
					return;
				}

				if (nextElement != null && nextElement.startsWith(word)) {
					System.out.println("BAD SET");
					System.out.println(word);
					return;
				}
			} else {
				System.out.println("BAD SET");
				System.out.println(word);
				return;
			}
		}
		System.out.println("GOOD SET");
	}

	public static void main(String[] args) {
		noPrefix(List.of("aab", "aac", "aacghgh"));
	}
}
