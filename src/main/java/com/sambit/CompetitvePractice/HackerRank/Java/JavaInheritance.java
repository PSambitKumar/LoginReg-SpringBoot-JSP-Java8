package com.sambit.CompetitvePractice.HackerRank.Java;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 19/11/2022 - 8:22 PM
 */

class Animal{
	void walk(){
		System.out.println("I am walking");
	}
}

class Bird extends Animal{
	void fly(){
		System.out.println("I am flying");
	}
	void sing(){
		System.out.println("I am singing");
	}
}

public class JavaInheritance {
	public static void main(String[] args) {
		Bird bird = new Bird();
		bird.walk();
		bird.fly();
	}

}
