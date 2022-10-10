package com.sambit.CompetitvePractice.DataStructure;

import java.sql.Struct;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 12:53 PM
 */
public class SinglyLinkedList {
	static class Node {
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

//	Add Data to Linked List Method
	public void addNode(int data){
		Node newNode = new Node(data);
		if (head == null){
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}

//	Display Single Linked List Data
	public void display(){
		Node current = head;

		if (current == null){
			System.out.println("Node is Empty!");
		}
		System.out.println("Data of Linked List are : ");
		while (current != null){
			System.out.print(current.data +", ");
			current = current.next;
		}
		System.out.println();
	}

//	Single Linked List Size Calculation
	public int sizeOfLinkedList(){
		Node current = head;
		int size = 0;
		if (current == null){
			return size;
		}else {
			while (current != null){
				size += 1;
				current = current.next;
			}
			return size;
		}
	}

//	Display Specific Node Data
	public int displaySpecificNodeData(int nodeNumber){
		int currentNodeNumber = 1;

		if (head != null){
			if (currentNodeNumber == nodeNumber){
				return head.data;
			}else {
				Node current = head;
				while (current != null){
					current = current.next;
					currentNodeNumber += 1;
					if (currentNodeNumber == nodeNumber){
						break;
					}else {
						System.out.println("Node Index Out Of Bound!");
					}
				}
				return current.data;
			}
		}else {
			System.out.println("Empty Linked List!");
			return 0;
		}
	}
}
