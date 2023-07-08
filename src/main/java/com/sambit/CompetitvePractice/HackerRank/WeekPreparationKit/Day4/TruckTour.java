package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day4;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 16/10/2022 - 12:06 PM
 */
public class TruckTour {
	public static int truckTour(List<List<Integer>> petrolpumps) {
		int st = 0;
		int ed = 1;
		int n = petrolpumps.size();
		int currPetrol = petrolpumps.get(st).get(0) - petrolpumps.get(st).get(1);
		while (st != ed || currPetrol < 0) {
			while (currPetrol < 0 && st != ed) {
				currPetrol -= petrolpumps.get(st).get(0) - petrolpumps.get(st).get(1);
				st = (st + 1) % n;
				if (st == 0) {
					return -1;
				}
			}
			currPetrol += petrolpumps.get(ed).get(0) - petrolpumps.get(ed).get(1);
			ed = (ed + 1) % n;
		}
		return st;
	}

	public static int truckTour(int[][] petrolpumps) {
		int st = 0;
		int ed = 1;
		int n = petrolpumps.length;
		int currPetrol = petrolpumps[st][0] - petrolpumps[st][1];
		while (st != ed || currPetrol < 0) {
			while (currPetrol < 0 && st != ed) {
				currPetrol -= petrolpumps[st][0] - petrolpumps[st][1];
				st = (st + 1) % n;
				if (st == 0) {
					return -1;
				}
			}
			currPetrol += petrolpumps[ed][0] - petrolpumps[ed][1];
			ed = (ed + 1) % n;
		}
		return st;
	}

	public static void main(String[] args) {
		System.out.println(truckTour(List.of(List.of(1, 5), List.of(10, 3), List.of(3, 4))));
		System.out.println(truckTour(List.of(List.of(0, 3), List.of(1, 2), List.of(2, 1), List.of(3, 0))));

		System.out.println(truckTour(new int[][]{{1, 5}, {10, 3}, {3, 4}}));
	}
}
