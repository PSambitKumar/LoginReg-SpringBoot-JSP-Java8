package com.sambit.CompetitvePractice.HackerRank.WeekPreparationKit.Day5;


import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 17/10/2022 - 10:09 PM
 */
public class MergeTwoSortedLinkedList {
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
	   SinglyLinkedListNode head = null;
	   SinglyLinkedListNode tail = null;
	   while (head1 != null && head2 != null) {
		  if (head1.data < head2.data) {
			 if (head == null) {
				head = head1;
				tail = head1;
			 } else {
				tail.next = head1;
				tail = tail.next;
			 }
			 head1 = head1.next;
		  } else {
			 if (head == null) {
				head = head2;
				tail = head2;
			 } else {
				tail.next = head2;
				tail = tail.next;
			 }
			 head2 = head2.next;
		  }
	   }
	   if (head1 != null) {
		  tail.next = head1;
	   }
	   if (head2 != null) {
		  tail.next = head2;
	   }
	   return head;
    }

}
