package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day6;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 17/10/2022 - 8:56 PM
 */
public class LegoBlocks {
	private static final int MOD = 1000000007;

	public static int legoBlocks(int n, int m) {
		int mod = 1000000007;
		long[] dpLowest = new long[m+1];
		long[] dpAll = new long[m+1];
		long[] dpGood = new long[m+1];

		for(int j=1; j<=m; j++) {
			if (j == 1) {
				dpLowest[j] = 1;
			} else if (j == 2) {
				dpLowest[j] = 2;
			} else if (j == 3) {
				dpLowest[j] = 4;
			} else if (j == 4) {
				dpLowest[j] = 8; // 1111 112 121 13 211 22 31 4
			} else {
				dpLowest[j] = mod(dpLowest[j-1] + dpLowest[j-2] + dpLowest[j-3] + dpLowest[j-4]);
			}
		}

		for(int i=1; i<=m; i++) {
			dpAll[i] = 1;
			for(int j=1; j<=n; j++)
				dpAll[i] = mod(dpLowest[i]*dpAll[i]);
		}

		for(int i=1; i<=m; i++) {
			if (i == 1) {
				dpGood[i] = 1;
				continue;
			}
			dpGood[i] = dpAll[i];
			for(int j=1; j<i; j++) {
				dpGood[i] = mod(dpGood[i]- (dpGood[i-j]*dpAll[j]));
			}
		}

		return  (int)mod(dpGood[m]);
	}

	private static long mod(long l1) {
		long modded = l1% LegoBlocks.MOD;
		if (modded < 0) {
			modded+= LegoBlocks.MOD;
		}
		return modded;
	}

}
