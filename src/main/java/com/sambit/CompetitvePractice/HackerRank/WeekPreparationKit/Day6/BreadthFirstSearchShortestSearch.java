package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day6;

import java.util.*;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 18/10/2022 - 10:04 AM
 */
public class BreadthFirstSearchShortestSearch {
	public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			graph.put(i, new ArrayList<>());
		}
		for (List<Integer> edge : edges) {
			graph.get(edge.get(0)).add(edge.get(1));
			graph.get(edge.get(1)).add(edge.get(0));
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		int[] distance = new int[n + 1];
		Arrays.fill(distance, -1);
		distance[s] = 0;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int neighbour : graph.get(node)) {
				if (distance[neighbour] == -1) {
					distance[neighbour] = distance[node] + 6;
					queue.add(neighbour);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (i != s) {
				result.add(distance[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(bfs(4, 2, List.of(List.of(1, 2), List.of(1, 3)), 1));
	}
}
