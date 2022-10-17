package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day4;

import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 16/10/2022 - 11:32 AM
 */
public class NewYearChaos {

	static void minimumBribes(List<Integer> q) {
		int count = 0;
		for (int i = q.size() - 1; i >= 0; i--) {
			if (q.get(i) - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
				if (q.get(j) > q.get(i)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

    static void minimumBribes(int[] q) {
	   int count = 0;
	   for (int i = q.length - 1; i >= 0; i--) {
		  if (q[i] - (i + 1) > 2) {
			 System.out.println("Too chaotic");
			 return;
		  }
		  for (int j = Math.max(0, q[i] - 2); j < i; j++) {
			 if (q[j] > q[i]) {
				count++;
			 }
		  }
	   }
	   System.out.println(count);
    }

	public static void main(String[] args) {
		minimumBribes(new int[]{2, 1, 5, 3, 4});
		minimumBribes(new int[]{2, 5, 1, 3, 4});
		minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
		minimumBribes(new int[]{1, 2, 5, 3, 4, 7, 8, 6});

		minimumBribes(List.of(2, 1, 5, 3, 4));
		minimumBribes(List.of(2, 5, 1, 3, 4));
	}
}
