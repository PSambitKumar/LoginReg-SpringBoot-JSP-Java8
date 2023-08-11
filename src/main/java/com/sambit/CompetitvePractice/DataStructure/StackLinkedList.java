package com.sambit.CompetitvePractice.DataStructure;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 14/10/2022 - 11:56 AM
 */
public class StackLinkedList {
    static class Node{
	   int data;
	   Node next;
	   public Node(int data){
		  this.data = data;
		  this.next = null;
	   }
    }
    public static Node top = null;
    public static Node bottom = null;
    public int length = 0;

    public void push(int data){
	   Node newNode = new Node(data);
	   if (top == null){
		  top = newNode;
		  bottom = newNode;
	   }else {
		  Node temp = top;
		  top = newNode;
		  newNode.next = temp;
	   }
	   length++;
    }

    public void pop(){
	   if (top == null){
		  System.out.println("Stack is Empty!");
	   }else {
		  Node temp = top;
		  top = top.next;
		  temp.next = null;
		  length--;
	   }
    }

    public void peek(){
	   if (top == null){
		  System.out.println("Stack is Empty!");
	   }else {
		  System.out.println("Top Element is : "+top.data);
	   }
    }

    public void display(){
	   if (top == null){
		  System.out.println("Stack is Empty!");
	   }else {
		  Node current = top;
		  while (current != null){
			 System.out.println(current.data);
			 current = current.next;
		  }
	   }
    }


}
