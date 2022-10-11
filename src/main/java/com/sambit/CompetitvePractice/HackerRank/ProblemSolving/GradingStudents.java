package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 9:42 PM
 */
public class GradingStudents {
	public static List<Integer> gradingStudents(List<Integer> grades){
		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i) >= 38){
				int mod = grades.get(i) % 5;
				if (mod >= 3){
					grades.set(i, grades.get(i) + (5 - mod));
				}
			}
		}
		return grades;
	}

	public static int[] gradingStudents(int[] grades) {
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 38) {
				int mod = grades[i] % 5;
				if (mod >= 3) {
					grades[i] += 5 - mod;
				}
			}
		}
		return grades;
	}
}
