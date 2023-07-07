package com.sambit.CompetitvePractice.HackerRank.ProjectEuler;

import java.util.*;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 26/10/2022 - 5:25 PM
 */
public class NameScores {

//	All Test Case Passed
		protected static final char[] ALPHABET_ENG = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		protected static String[] namesToBeSorted;
		protected static ArrayList<String> listOfNames;

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			int amountOfNames = scan.nextInt();
			namesToBeSorted = new String[amountOfNames];
			for (int index = 0; index < namesToBeSorted.length; index++) {
				String name = scan.next();
				namesToBeSorted[index] = name;
			}
			Arrays.sort(namesToBeSorted);
			listOfNames = new ArrayList<String>(Arrays.asList(namesToBeSorted));
			int queries = scan.nextInt();
			while (queries-- > 0) {
				String nameToBeScored = scan.next();
				System.out.println(calculateNameScore(nameToBeScored));
			}
		}

		protected static int calculateNameScore(final String givenName) {
			int nameScore = 0;
			char[] nameScoringArray = givenName.toCharArray();
			int namePlace = listOfNames.indexOf(givenName) + 1;
			for (char c : nameScoringArray) {
				nameScore += findCharacterIndex(Character.toLowerCase(c)) + 1;
			}
			return nameScore * namePlace;
		}

		protected static int findCharacterIndex(char character) {
			for (int index = 0; index < NameScores.ALPHABET_ENG.length; index++)
				if (character == NameScores.ALPHABET_ENG[index]) { return index; }
			return -1;
		}


//	One Test Case Passed
	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> charMap = new HashMap<>();
		int Lplace = 1;
		for (char ch = 'A'; ch <= 'Z'; ++ch) {
			charMap.put(String.valueOf(ch), Lplace);
			Lplace++;
		}
		ArrayList<String> nameList = new ArrayList<>();

		int names = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < names; i++) {
			nameList.add(sc.nextLine().toUpperCase());
		}
		int b = sc.nextInt();
		sc.nextLine();
		Collections.sort(nameList);
		for (int j = 0; j < b; j++) {
			long result = 0;
			String test = sc.nextLine();
			test = test.toUpperCase();
			int order = nameList.indexOf(test) + 1;

			for (int i = 0; i < test.length(); i++) {
				result += charMap.get(Character.toString(test.charAt(i)));
			}
			System.out.println(order * result);
			sc.close();
		}
	}
}
