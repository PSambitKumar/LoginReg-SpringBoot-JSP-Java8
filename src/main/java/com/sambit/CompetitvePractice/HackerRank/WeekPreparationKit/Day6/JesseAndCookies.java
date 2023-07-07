package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day6;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 18/10/2022 - 9:52 AM
 */
public class JesseAndCookies {

//	All Test Cases Successfully Passes(Final Answer)
	public static int cookies(int k, List<Integer> A) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.addAll(A);
		int count = 0;
		while (queue.peek() < k) {
			if (queue.size() < 2) {
				return -1;
			}
			int first = queue.poll();
			int second = queue.poll();
			int newCookie = first + 2 * second;
			queue.add(newCookie);
			count++;
		}
		return count;
	}

	public static void cookies() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			q.add(tmp);
		}

		int counter = 0;
		while (q.size() > 1 && q.peek() <= k) {
			int first = q.poll();
			int second = q.poll();
			q.add(first + 2 * second);
			counter++;
		}

		if (q.peek() < k) {
			System.out.println(-1);
		} else {
			System.out.println(counter);
		}
	}

	public static void main(String[] args) {
		cookies();
		System.out.println(cookies(7, List.of(1, 2, 3, 9, 10, 12)));
	}
}
