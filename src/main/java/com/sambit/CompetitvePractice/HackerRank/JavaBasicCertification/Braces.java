package com.sambit.CompetitvePractice.HackerRank.JavaBasicCertification;

import java.util.Stack;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 10:22 PM
 */
public class Braces {
	static String isBalanced(String s){
		Stack<Character> str = new Stack();
		String ans = "true";
		String no = "false";
		boolean answer = true;
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(ch == '{' || ch == '[' || ch == '('){
				str.push(ch);
				continue;
			}
			if(str.isEmpty()){
				return no;

			}
			if(ch == ')'){
				if(str.peek() == '('){
					str.pop();
				}else{
					answer = false;
					break;
				}
			}
			if(ch == ']'){
				if(str.peek() == '['){
					str.pop();
				}else{
					answer = false;
					break;
				}
			}
			if(ch == '}'){
				if(str.peek() == '{'){
					str.pop();
				}else{
					answer = false;
					break;
				}
			}


		}
		if(!str.isEmpty()){
			answer = false;
		}
		if(answer)
			return ans;
		else
			return no;
	}
}
