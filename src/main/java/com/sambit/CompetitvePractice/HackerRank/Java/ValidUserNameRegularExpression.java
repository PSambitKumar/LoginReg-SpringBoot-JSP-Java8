package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 11:41 AM
 */
public class ValidUserNameRegularExpression {
//	You are updating the username policy on your company's internal networking platform. According to the policy, a username is considered valid if all the following constraints are satisfied:
//	The username consists of  to  characters inclusive. If the username consists of less than  or greater than  characters, then it is an invalid username.
//	The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters , uppercase characters , and digits .
//	The first character of the username must be an alphabetic character, i.e., either lowercase character  or uppercase character .
	public static void main(String[] args) {

//		Dynamic
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		while (n-- > 0) {
			String userName = sc.nextLine();
			if (userName.matches("^[a-zA-Z][a-zA-Z0-9_]{7,29}$")) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
		}

//		Static
		String[] inputs = {"Julia", "Samantha", "Samantha_21", "1Samantha", "Samantha?10_2A", "JuliaZ007", "Julia@007", "_Julia007"};
		for (String input : inputs) {
			System.out.println(input + " : " + (input.matches("^[a-zA-Z][a-zA-Z0-9_]{7,29}$") ? "Valid" : "Invalid"));
		}
	}
}
