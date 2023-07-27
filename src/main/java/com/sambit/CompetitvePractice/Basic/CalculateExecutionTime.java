package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 27/07/2023 - 10:05 PM
 */
public class CalculateExecutionTime {
    public void display() {
        System.out.println("Calculating Method execution time:");
    }

    public static void main(String[] args) {
        CalculateExecutionTime obj = new CalculateExecutionTime();
        long start = System.nanoTime();

        obj.display();
        long end = System.nanoTime();
        long execution = end - start;

        System.out.println("Execution time: " + execution + " nanoseconds");
    }
}
