package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 9:25 PM
 */
public class BirthdayCakeCandles {
	public static int birthdayCakeCandles(List<Integer> candles) {
		int max = 0;
		int count = 0;
		for (Integer candle : candles) {
			if (candle > max){
				max = candle;
				count = 1;
			}else if (candle == max){
				count += 1;
			}
		}
		return count;
	}

	public static int birthdayCakeCandles(int[] ar) {
		int max = 0;
		int count = 0;
		for (int i : ar) {
			if (i > max) {
				max = i;
				count = 1;
			} else if (i == max) {
				count++;
			}
		}
		return count;
	}


}
