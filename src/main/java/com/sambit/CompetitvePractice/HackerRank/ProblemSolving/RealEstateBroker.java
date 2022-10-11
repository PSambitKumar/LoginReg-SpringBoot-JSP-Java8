package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 9:30 PM
 */
public class RealEstateBroker {

	static int realEstateBroker(int[][] clients, int[][] houses){
		int count = 0;
		for (int[] client : clients) {
			for (int[] house : houses) {
				if (client[0] >= house[0] && client[1] >= house[1]) {
					count++;
					break;
				}
			}
		}
		return count;
	}


	static int realEstateBroker1(int[][] clients, int[][] houses){
		int count = 0;
		for (int[] client : clients) {
			for (int[] house : houses) {
				if (client[0] >= house[0] && client[1] >= house[1] && client[2] >= house[2]) {
					count++;
					break;
				}
			}
		}
		return count;
	}
}
