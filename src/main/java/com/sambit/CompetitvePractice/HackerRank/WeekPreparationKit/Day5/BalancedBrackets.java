package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day5;

import java.util.Stack;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 17/10/2022 - 12:18 PM
 */
public class BalancedBrackets {

//	Final All Test Case Passed
	public static String isBalanced(String s){
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return "NO";
				}
				char c = stack.pop();
				if (s.charAt(i) == ')' && c != '(') {
					return "NO";
				} else if (s.charAt(i) == '}' && c != '{') {
					return "NO";
				} else if (s.charAt(i) == ']' && c != '[') {
					return "NO";
				}
			}
		}
		if (stack.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
	}

	public static void main(String[] args) {
	   System.out.println(isBalanced("{[()]}"));
    }

//    static String isBalanced(String s) {
//	   int st = 0;
//	   int ed = s.length() - 1;
//	   while (st < ed) {
//		  if (s.charAt(st) == '{' && s.charAt(ed) == '}') {
//			 st++;
//			 ed--;
//		  } else if (s.charAt(st) == '[' && s.charAt(ed) == ']') {
//			 st++;
//			 ed--;
//		  } else if (s.charAt(st) == '(' && s.charAt(ed) == ')') {
//			 st++;
//			 ed--;
//		  } else {
//			 return "NO";
//		  }
//	   }
//	   return "YES";
//    }
}
