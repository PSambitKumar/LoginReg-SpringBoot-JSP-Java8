package com.sambit.CompetitvePractice.DataStructure;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 13/10/2022 - 3:06 PM
 */
public class CircularLinkedList {
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

    //Add Node To Circular Linked List
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

	//		Display Node Data
	void displayData(){
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

//	Add Node At The End
	void addNodeAtEnd(int data){
		Node newNode = new Node(data);
		if (head == null){
			head = newNode;
			tail = newNode;
		}else {
			Node temp = head;
			head = newNode;
			newNode.next = temp;
			temp.prev = newNode;
			System.out.println("Node Inserted At The End Of The List.");
		}
	}

//	Add Node At The Beginning
	void addNodeAtBegin(int data){
		Node newNode = new Node(data);
		if (head == null){
			head = newNode;
			tail = newNode;
		}else {
			Node temp = head;
			head = newNode;
			newNode.next = temp;
			temp.prev = newNode;
			System.out.println("Node Inserted At The Beginning Of The List.");
		}
	}

//	Add Node Using Node Number
	void addNodeUsingNodeNumber(int data, int nodeNumber){
		Node newNode = new Node(data);
		if (head == null){
			head = newNode;
			tail = newNode;
		}else {
			Node temp = head;
			int i = 1;
			while (i < nodeNumber - 1){
				temp = temp.next;
				i++;
			}
			Node temp2 = temp.next;
			temp.next = newNode;
			newNode.prev = temp;
			newNode.next = temp2;
			temp2.prev = newNode;
			System.out.println("Node Inserted At The Node Number : " + nodeNumber);
		}
	}

//	Delete Node Using Node Number
	void deleteNodeWithNodeNumber(int nodeNumber){
		Node current = head;
		int i = 1;
		if (head == null){
			System.out.println("Node is Empty!");
		}else {
			while (i < nodeNumber){
				current = current.next;
				i++;
			}
			if (current == head){
				head = current.next;
				current.next.prev = null;
				current.next = null;
			}else if (current == tail){
				tail = current.prev;
				current.prev.next = null;
				current.prev = null;
			}else {
				current.prev.next = current.next;
				current.next.prev = current.prev;
				current.next = null;
				current.prev = null;
			}
		}
	}


}
