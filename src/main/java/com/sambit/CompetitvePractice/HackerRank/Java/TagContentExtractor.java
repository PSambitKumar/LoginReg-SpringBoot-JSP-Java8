package com.sambit.CompetitvePractice.HackerRank.Java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 06/11/2022 - 8:06 PM
 */
public class TagContentExtractor {
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		while (testCases-- > 0) {
			String line = scan.nextLine();
			boolean matchFound = false;
			Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
			Matcher m = r.matcher(line);
			while (m.find()) {
				System.out.println(m.group(2));
				matchFound = true;
			}
			if (!matchFound) {
				System.out.println("None");
			}
		}
		scan.close();
	}
}
