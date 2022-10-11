package com.sambit.CompetitvePractice.HackerRank.ProblemSolving;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 11/10/2022 - 11:46 AM
 */
public class NumberLineJumps {
    public static void main(String[] args) {
	   int x1 = 0;
	   int v1 = 3;
	   int x2 = 4;
	   int v2 = 2;
	   System.out.println(kangaroo(x1, v1, x2, v2));
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
	   if (x1 < x2 && v1 < v2)
		  return "NO";
	   else if (x1 > x2 && v1 > v2)
		  return "NO";
	   else if (x1 == x2 && v1 == v2)
		  return "YES";
	   else if (x1 == x2 && v1 != v2)
		  return "NO";
	   else if (x1 != x2 && v1 == v2)
		  return "NO";
	   else {
		  int x1New = x1;
		  int x2New = x2;
		  while (x1New < x2New) {
			 x1New += v1;
			 x2New += v2;
			 if (x1New == x2New)
				return "YES";
		  }
		  return "NO";
	   }
    }
}
