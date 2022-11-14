package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 14/11/2022 - 9:42 AM
 */
public class DictionaryAndMaps {
	public static void main(String []argh){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map <String,Integer> myMap= new HashMap<>();
		for(int i = 0; i < n; i++){
			String name = in.next();
			int phone = in.nextInt();
			myMap.put(name,phone);
		}
		while(in.hasNext()){

			String name = in.next();
			if (myMap.containsKey(name)) {
				int phone = myMap.get(name);
				System.out.println(name + "=" + phone);
			} else System.out.println("Not found");
		}
		in.close();
	}
}
