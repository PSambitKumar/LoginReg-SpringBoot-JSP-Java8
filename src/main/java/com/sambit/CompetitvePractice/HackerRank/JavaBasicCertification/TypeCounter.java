package com.sambit.CompetitvePractice.HackerRank.JavaBasicCertification;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 12:55 PM
 */
public class TypeCounter {
	public static void typeCounter(String sentence) {
		int stringCount = 0;
		int integerCount = 0;
		int doubleCount = 0;

		String[] words = sentence.split(" ");
		for (String word : words) {
			try {
				Integer.parseInt(word);
				integerCount++;
			} catch (NumberFormatException e) {
				try {
					Double.parseDouble(word);
					doubleCount++;
				} catch (NumberFormatException e1) {
					stringCount++;
				}
			}
		}
		System.out.println("string " + stringCount);
		System.out.println("integer " + integerCount);
		System.out.println("double " + doubleCount);
	}

	public static void main(String[] args) {
		typeCounter("Sambit Kumar Pradhan 12 12.90");
	}
}
