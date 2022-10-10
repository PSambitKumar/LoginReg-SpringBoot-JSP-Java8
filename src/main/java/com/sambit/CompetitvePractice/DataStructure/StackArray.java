package com.sambit.CompetitvePractice.DataStructure;

import javax.swing.plaf.PanelUI;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 11:20 AM
 */
public class StackArray {
	int top = -1;
	int[] stack;

	public StackArray(int size) {
		stack = new int[size];
	}

//	Check Size of Stack Method
	int sizeOfStack(){
		return this.stack.length;
	}

//	Check Stack Is Empty Or Not
	public boolean isEmpty(){
		return top == -1;
	}
//	Stack PUSH Method
	void push(int value){
		if (top == (stack.length-1)){
			System.out.println("Stack Overflow!");
		}else {
				stack[top + 1] = value;
				top += 1;
		}
	}

//	Stack POP Method
	void pop(){
		if (top == -1){
			System.out.println("Stack Underflow.");
		}else {
			stack[top] = 0;
			top -= 1;
		}
	}

//	Stack Elements Display Method
	public void display(){
		for (int i : stack) {
			System.out.println(i);
		}
	}


}
