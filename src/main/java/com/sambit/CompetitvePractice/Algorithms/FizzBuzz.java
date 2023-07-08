package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 21/09/2022 - 3:38 PM
 */

//Fizz Buzz Algorithm
/*Fizz and Buzz refer to any number that's a multiple of 3 and 5 respectively. In other words, if a number is divisible
	   by 3, it is substituted with fizz; if a number is divisible by 5, it is substituted with buzz. If a number is simultaneously
	   a multiple of 3 AND 5, the number is replaced with "fizz buzz." In essence, it emulates the famous children game"fizz buzz".*/

public class FizzBuzz {
	public static void fizzBuzz() {
	   for (int i = 1; i <= 100; i++) {
		  if (i % 3 == 0 && i % 5 == 0) {
			 System.out.println("FizzBuzz");
		  } else if (i % 3 == 0) {
			 System.out.println("Fizz");
		  } else if (i % 5 == 0) {
			 System.out.println("Buzz");
		  } else {
			 System.out.println(i);
		  }
	   }
    }
}
