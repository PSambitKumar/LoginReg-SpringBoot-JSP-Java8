package com.sambit.CompetitvePractice.HackerRank.Java;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 21/11/2022 - 10:09 AM
 */
public class JavaInheritanceII {

    public static void main(String []args){
        // Create a new Adder object
        Adder a = new Adder();
        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());
        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
    }
}

class Arithmetic {
    public int add(int a, int b) {
        return a + b;
    }
}

class Adder extends Arithmetic {
}
