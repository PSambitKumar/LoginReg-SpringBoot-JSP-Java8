package com.sambit.CompetitvePractice.HackerRank.Certification.ProblemSolvingBasic;

import java.util.*;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 10:01 PM
 */
public class StringAnagram {

//	HackerRank Problem Solving Certification Question - String Anagram
	public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> dictMap = new HashMap<>();
		dictionary.forEach(dict -> {
			char[] tempArray = dict.toCharArray();
			Arrays.sort(tempArray);
			String sortedDict = new String(tempArray);
			if (dictMap.containsKey(sortedDict)) {
				dictMap.put(sortedDict, dictMap.get(sortedDict) + 1);
			} else {
				dictMap.put(sortedDict, 1);
			}
		});
		query.forEach(queryData -> {
			char[] tempArray = queryData.toCharArray();
			Arrays.sort(tempArray);
			String sortedQuery = new String(tempArray);
			int count = 0;
			if (dictMap.containsKey(sortedQuery)) {
				count = dictMap.get(sortedQuery);
			}
			answer.add(count);
		});
		return answer;
	}
}
