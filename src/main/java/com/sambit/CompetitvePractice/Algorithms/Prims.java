package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 11:00 AM
 */
public class Prims {

	public static void prims(int[][] graph, int n) {
	   int[] parent = new int[n];
	   int[] key = new int[n];
	   boolean[] mstSet = new boolean[n];
	   for (int i = 0; i < n; i++) {
		  key[i] = Integer.MAX_VALUE;
		  mstSet[i] = false;
	   }
	   key[0] = 0;
	   parent[0] = -1;
	   for (int count = 0; count < n - 1; count++) {
		  int u = minKey(key, mstSet, n);
		  mstSet[u] = true;
		  for (int v = 0; v < n; v++) {
			 if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
				parent[v] = u;
				key[v] = graph[u][v];
			 }
		  }
	   }
	   printMST(parent, n, graph);
	}

	private static int minKey(int[] key, boolean[] mstSet, int n) {
	   int min = Integer.MAX_VALUE, min_index = -1;
	   for (int v = 0; v < n; v++) {
		  if (mstSet[v] == false && key[v] < min) {
			 min = key[v];
			 min_index = v;
		  }
	   }
	   return min_index;
	}

	private static void printMST(int[] parent, int n, int[][] graph) {
	   System.out.println("Edge \tWeight");
	   for (int i = 1; i < n; i++) {
		  System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	   }
	}

}
