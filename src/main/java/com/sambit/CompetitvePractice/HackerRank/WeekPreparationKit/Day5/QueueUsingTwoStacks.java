

package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
    *@Project : Registration
    *@Auther : Sambit Kumar Pradhan
    *@Created On : 17/10/2022 - 12:12 PM
*/public class QueueUsingTwoStacks {
	private static class StackQueue<T> {

		private Stack<T> stack = new Stack<>(), auxStack = new Stack<>();

		void enqueue(T elem) {
			stack.push(elem);
		}

		T dequeue() {
			if (auxStack.isEmpty()) {
				if (stack.isEmpty()) {
					System.out.println("Queue underflow");
					return null;
				}
				while (!stack.isEmpty()) {
					auxStack.push(stack.pop());
				}
			}
			return auxStack.pop();
		}

		T peek() {
			if (auxStack.isEmpty()) {
				if (stack.isEmpty()) {
					System.out.println("Queue underflow");
					return null;
				}
				while (!stack.isEmpty()) {
					auxStack.push(stack.pop());
				}
			}
			return auxStack.peek();
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		scan.nextLine();    // Gets rid of the newline char
		List<String> queries = new ArrayList<>(q);

		// Query gathering
		for (int i = 0; i < q; i++) {
			queries.add(scan.nextLine());
		}
		scan.close();

		// Query handling
		int type, val;
		StackQueue<Integer> queue = new StackQueue<>();

		for (String query : queries) {
			type = query.charAt(0);
			if (type == '1') {
				val = Integer.parseInt(query.substring(2));
				queue.enqueue(val);
			}
			else if (type == '2') {
				queue.dequeue();
			}
			else {
				System.out.println(queue.peek());
			}
		}
	}
}
