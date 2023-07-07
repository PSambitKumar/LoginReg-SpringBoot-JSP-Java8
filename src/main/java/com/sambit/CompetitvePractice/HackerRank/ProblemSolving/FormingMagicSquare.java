package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 11:59 AM
 */
public class FormingMagicSquare {

	public static int formingMagicSquare(List<List<Integer>> s) {
		int[][][] magicSquares = {
			   {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
			   {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
			   {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
			   {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
			   {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
			   {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
			   {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
			   {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
		};
		int minCost = Integer.MAX_VALUE;
		for (int[][] magicSquare : magicSquares) {
			int cost = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cost += Math.abs(magicSquare[i][j] - s.get(i).get(j));
				}
			}
			minCost = Math.min(minCost, cost);
		}
		return minCost;
	}

	public static int formingMagicSquare(int[][] s) {
		int[][][] magicSquares = {
			   {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
			   {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
			   {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
			   {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
			   {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
			   {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
			   {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
			   {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
		};
		int minCost = Integer.MAX_VALUE;
		for (int[][] magicSquare : magicSquares) {
			int cost = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cost += Math.abs(magicSquare[i][j] - s[i][j]);
				}
			}
			minCost = Math.min(minCost, cost);
		}
		return minCost;
	}

	public static void main(String[] args) {
		System.out.println(formingMagicSquare(new int[][]{{4, 9, 2}, {3, 5, 7}, {8, 1, 5}}));
		System.out.println(formingMagicSquare(List.of(List.of(4, 9, 2), List.of(3, 5, 7), List.of(8, 1, 5))));
	}
}
