package com.sambit.CompetitvePractice.DataStructure;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
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

//	Display All Node Data
	void display(){
		Node current = head;
		if (current == null) {
			System.out.println("Node is Empty!");
		} else {
			System.out.println("Data of Linked List are : ");
			while (current != null){
				System.out.println(current.data);
				current = current.next;
			}
		}
	}

//	Add Node At The Beginning
	void addNodeBegin(int data){
		Node newNode = new Node(data);
		if (head == null){
			head = newNode;
			tail = newNode;
		}else {
			Node temp = head;
			head = newNode;
			newNode.next = temp;
		}
	}

//	Add Node At The End Of The Linked List
	void addNodeEnd(int data){
		Node newNode = new Node(data);
		if (head == null){
			head = newNode;
			tail = newNode;
		}else {
			Node current = head;
			while (current.next != null){
				current = current.next;
			}
			current.next = newNode;
			tail = current;
		}
	}

//	Delete Node At The End
	void deleteNodeEnd(){
		if (head == null){
			System.out.println("Node is Empty!");
		}else {
			Node prev = null;
			Node current = head;
			while (current.next != null){
				prev = current;
				current = current.next;
			}
			prev.next = null;
			tail = prev;
			System.out.println("Last Node Deleted Successfully.");
		}
	}
}
