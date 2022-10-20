package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 20/10/2022 - 12:20 PM
 */
public class JavaRegex {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String IP = in.next();
			System.out.println(IP.matches(new MyRegex().pattern));
		}
	}
}

class MyRegex {
	String pattern = "((([0-1]?[0-9]?[0-9])|(2[0-4][0-9])|(25[0-5]))\\.){3}(([0-1]?[0-9]?[0-9])|(2[0-4][0-9])|(25[0-5]))";
}
