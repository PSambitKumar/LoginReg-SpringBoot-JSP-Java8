package com.sambit.CompetitvePractice.DataStructure;

import com.sambit.Utils.ANSIColors;
import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 11:25 AM
 */
public class MainClass {
	public static void main(String[] args) {
		System.out.println("Play With Data Structure.");
		System.out.println("Select Your Choice?");
		System.out.println(
			   "1. Stack\n" +
			   "2. Linked List\n" +
			   "3. Doubly Linked List\n" +
			   "4. Circular Linked List\n" +
			   "5. Stack Using Linked List\n"
		);
		int input = new Scanner(System.in).nextInt();
		if (input == 1){
			System.out.println("Enter Size of Stack?");
			int size = new Scanner(System.in).nextInt();
			StackArray stackArray = new StackArray(size);

			char response;

			while (true){
				System.out.println("a. Push\nb. Pop\nc. Size\nd. Display\ne. Exit");
				System.out.println("Choose Your Option?");
				response = new Scanner(System.in).next().charAt(0);
				if (response == 'a' || response == 'A'){
					System.out.println("Enter Value?");
					stackArray.push(new Scanner(System.in).nextInt());
				}else if (response == 'b' || response == 'B')
					stackArray.pop();
				else if (response == 'c' || response =='C')
					System.out.println("Size of The Stack Is : " + stackArray.sizeOfStack());
				else if (response == 'd' || response =='D')
					stackArray.display();
				else if (response == 'e' || response == 'E') {
					System.out.println("Exiting...");
					System.exit(0);
				} else {
					System.out.println("Invalid Option.");
				}
			}
		} else if (input == 2) {
			SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
			char response1;
			while(true){
				System.out.println(
					   "a. add Node\n" +
					   "b. Delete Node\n" +
					   "c. Size\n" +
					   "d. Display\n" +
					   "f. Display Using Specific Node Number\n" +
					   "g. Delete Last Node\n" +
					   "h.Delete First Node\n" +
					   "i.Delete Node Using Specific Node Number\n" +
					   "e. Exit"
				);
				System.out.println("Choose Your Option?");
				response1 = new Scanner(System.in).next().charAt(0);
				if (response1 == 'a' || response1 == 'A'){
					System.out.println("Enter Data For Node?");
					singlyLinkedList.addNode(new Scanner(System.in).nextInt());
				} else if (response1 == 'c' || response1 == 'C') {
					System.out.println(ANSIColors.ansiRed + "Size of The Linked List : " + ANSIColors.ansiReset + singlyLinkedList.sizeOfLinkedList());
				} else if (response1 == 'd' || response1 == 'D') {
					singlyLinkedList.display();
				} else if (response1 == 'f' || response1 =='F'){
					System.out.println(singlyLinkedList.displaySpecificNodeData(new Scanner(System.in).nextInt()));
				} else if (response1 == 'g' || response1 == 'G') {
					singlyLinkedList.deleteNodeAtEnd();
				} else if (response1 == 'h' || response1 == 'H') {
					singlyLinkedList.deleteFirstNode();
				} else if (response1 == 'i' || response1 == 'I') {
					singlyLinkedList.deleteSpecificNode(new Scanner(System.in).nextInt());
				} else if (response1 == 'e' || response1 == 'E'){
					System.exit(0);
				}
			}
		} else if (input == 3){
			DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
			char response2;
			while (true){
				System.out.println(
					   "a. Add Node\n" +
					   "b. Delete Node\n" +
					   "c. Size\n" +
					   "d. Display\n" +
					   "f. Add Node At The Beginning\n" +
					   "g. Add Node At The Ending\n" +
					   "h. Delete Node At The Ending\n" +
					   "i. Delete Node At The Beginning\n" +
					   "e. Exit"
				);
				System.out.println("Choose Your Option?");
				response2 = new Scanner(System.in).next().charAt(0);
				if (response2 == 'a' || response2 == 'A'){
					System.out.println("Enter Data For Node?");
					doublyLinkedList.addNode(new Scanner(System.in).nextInt());
				} else if (response2 == 'd' || response2 == 'D'){
					System.out.println("Displaying Node Data.");
					doublyLinkedList.display();
				} else if (response2 == 'f' || response2 == 'F'){
					System.out.println("Enter Data For Node?");
					doublyLinkedList.addNodeBegin(new Scanner(System.in).nextInt());
				} else if (response2 == 'g' || response2 == 'G'){
					System.out.println("Enter Data For Node?");
					doublyLinkedList.addNodeEnd(new Scanner(System.in).nextInt());
				}
			}
		} else if (input == 4) {
			CircularLinkedList circularLinkedList = new CircularLinkedList();
			char response3;
			while (true){
				System.out.println(
					   "a. Add Node\n" +
					   "b. Delete Node\n" +
					   "c. Delete Node\n" +
					   "d. Display\n" +
					   "e. Size\n" +
					   "f. Add Node at The Beginning\n" +
					   "g. Add Node at The End\n" +
					   "h. Add Node at Node Number\n" +
					   "i. Delete Node at Node Number\n"
				);
				System.out.println("Choose Your Option?");
				response3 = new Scanner(System.in).next().charAt(0);
				if (response3 == 'a' || response3 == 'A'){
					System.out.println("Enter Value For Node Data?");
					circularLinkedList.addNode(new Scanner(System.in).nextInt());
				}else if (response3 == 'd' || response3 == 'D'){
					circularLinkedList.displayData();
				}else if (response3 == 'g' || response3 == 'G'){
					System.out.println("Enter Value For Node Data?");
					circularLinkedList.addNodeAtEnd(new Scanner(System.in).nextInt());
				}else if (response3 == 'f' || response3 == 'F'){
					System.out.println("Enter Value For Node Data?");
					circularLinkedList.addNodeAtBegin(new Scanner(System.in).nextInt());
				} else if (response3 == 'i' || response3 == 'I'){
					System.out.println("Enter Node Number to Delete?");
					circularLinkedList.deleteNodeWithNodeNumber(new Scanner(System.in).nextInt());
				}else if (response3 == 'h' || response3 == 'H'){
					System.out.println("Enter Node Number to Add Data?");
					circularLinkedList.addNodeUsingNodeNumber(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt());
				}else {
					System.out.println("Invalid Input");
				}
			}
		}else if (input == 5){
			StackLinkedList stackLinkedList = new StackLinkedList();
			char response4;
			while(true){
				System.out.println(
					     "a. Push Data\n" +
						"b. Pop Data\n" +
						"c. Size of Stack\n" +
						"d. Display Data\n" +
						"e. Peak Data\n" +
						"0. Exit"
				);
				System.out.println("Choose Your Option?");
				response4 = new Scanner(System.in).next().charAt(0);
				if (response4 == 'a' || response4 == 'A'){
					System.out.println("Enter Data For Push?");
					stackLinkedList.push(new Scanner(System.in).nextInt());
				}else if (response4 == 'b' || response4 == 'B') {
					stackLinkedList.pop();
				}else if (response4 == 'c' || response4 == 'C') {
					System.out.println("Size of Stack is " + stackLinkedList.length);
				}else if (response4 == 'd' || response4 == 'D') {
					stackLinkedList.display();
				}else if (response4 == 'e' || response4 == 'E') {
					stackLinkedList.peek();
				}else{
					System.out.println("Invalid Input");
				}
			}
		}else
			System.out.println("Invalid Option.");
	}
}
