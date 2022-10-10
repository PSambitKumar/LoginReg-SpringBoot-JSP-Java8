package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 11:04 AM
 */
public class MainClass {
    public static void main(String[] args) {
	    int[][] graph = new int[][]{
		       {0, 2, 0, 6, 0},
		       {2, 0, 3, 8, 5},
		       {0, 3, 0, 0, 7},
		       {6, 8, 0, 0, 9},
		       {0, 5, 7, 9, 0}
	    };

//	    Calling of Prims Algorithm Method
	    Prims.prims(graph, 5);
    }
}
