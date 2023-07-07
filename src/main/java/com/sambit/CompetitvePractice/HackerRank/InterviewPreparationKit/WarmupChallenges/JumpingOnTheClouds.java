package com.sambit.CompetitvePractice.HackerRank.InterviewPreparationKit.WarmupChallenges;

import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 12/10/2022 - 11:26 AM
 */
public class JumpingOnTheClouds {

	public static int jumpingOnClouds(List<Integer> c){
		int jump = 0;
		int i = 0;
		while (i < c.size() - 1){
			if (i + 2 < c.size() && c.get(i + 2) == 0){
				i += 2;
			} else {
				i++;
			}
			jump++;
		}
		return jump;
	}


	public static int jumpingOnClouds(int[] c) {
	   int jump = 0;
	   int i = 0;
	   while (i < c.length - 1) {
		  if (i + 2 < c.length && c[i + 2] == 0) {
			 i += 2;
		  } else {
			 i++;
		  }
		  jump++;
	   }
	   return jump;
    }

    public static void main(String[] args) {
	    System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
	    System.out.println(jumpingOnClouds(List.of(0, 0, 1, 0, 0, 1, 0)));
    }
}
