package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 20/10/2022 - 12:23 PM
 */
public class JavaReg2DuplicateWords {
	public static void main(String[] args) {
		String regex = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Scanner in = new Scanner(System.in);
		int numSentences = Integer.parseInt(in.nextLine());
		while (numSentences-- > 0) {
			String input = in.nextLine();
			Matcher m = p.matcher(input);
			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group(), m.group(1));
			}
			// Prints the modified sentence.
			System.out.println(input);
		}
		in.close();
	}
}
