package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 16/10/2022 - 12:19 AM
 */
public class GridChallenge {
	public static String gridChallenge(List<String> grid){
		List<char[]> matrix = grid
			   .stream()
			   .map(e -> {
				   char[] r = e.toCharArray();
				   Arrays.sort(r);
				   return r;
			   }).collect(Collectors.toList());

		for (int i = 0; i < matrix.get(0).length; i++) {
			for (int j = 1; j < matrix.size(); j++) {
				if (matrix.get(j - 1)[i] > matrix.get(j)[i]) {
					return "NO";
				}
			}
		}

		return "YES";
	}

	public static void main(String[] args) {
		System.out.println(gridChallenge(List.of("ebacd", "fghij", "olmkn", "trpqs", "xywuv")));
		System.out.println(gridChallenge(List.of("abc", "lmp", "qrt")));
		System.out.println(gridChallenge(List.of("mpxz", "abcd", "wlmf")));
		System.out.println(gridChallenge(List.of("abc", "hjk", "mpq", "rtv")));
	}
}

//    static String gridChallenge(List<String> grid) {
//	   int n = grid.size();
//	   int m = grid.get(0).length();
//	   char[][] arr = new char[n][m];
//	   for (int i = 0; i < n; i++) {
//		  for (int j = 0; j < m; j++) {
//			 arr[i][j] = grid.get(i).charAt(j);
//		  }
//
//	   }
//	   for (int i = 0; i < n; i++) {
//		  for (int j = 0; j < m; j++) {
//			 for (int k = j + 1; k < m; k++) {
//				if (arr[i][j] > arr[i][k]) {
//				    return "NO";
//				}
//			 }
//		  }
//	   }
//	   for (int i = 0; i < m; i++) {
//		  for (int j = 0; j < n; j++) {
//			 for (int k = j + 1; k < n; k++) {
//				if (arr[j][i] > arr[k][i]) {
//				    return "NO";
//				}
//			 }
//		  }
//	   }
//	   return "YES";
//    }

