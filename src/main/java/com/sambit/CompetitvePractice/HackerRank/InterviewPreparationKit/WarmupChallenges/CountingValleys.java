package com.sambit.CompetitvePractice.HackerRank.InterviewPreparationKit.WarmupChallenges;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 10:32 AM
 */
public class CountingValleys {
	public static int countingValleys(int steps, String path){
		int valley = 0;
		int level = 0;
		for (int i = 0; i < steps; i++){
			char c = path.charAt(i);
			if (c == 'U'){
				level++;
			}
			if (c == 'D'){
				level--;
			}
			if (level == 0 && c == 'U'){
				valley++;
			}
		}
		return valley;
	}

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
	}
}
