package com.sambit.CompetitvePractice.DataStructure;

import net.bytebuddy.asm.Advice;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import javax.security.auth.callback.CallbackHandler;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/10/2022 - 11:25 AM
 */
public class MainClass {
	public static void main(String[] args) {
		System.out.println("Play With Data Structure.");
		System.out.println("Select Your Choice?");
		System.out.println("1. Stack");
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
		}else
			System.out.println("Invalid Option.");
	}
}
