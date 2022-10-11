package com.sambit.CompetitvePractice.DataStructure;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 5:19 PM
 */
public class DoublyLinkedList {
	static class Node{
		Node prev;
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	public Node head = null;
	public Node tail  = null;


//	Add Node To Doubly Linked List
	void addNode(int data){
		Node newNode = new Node(data);
		if (head == null){
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
}
