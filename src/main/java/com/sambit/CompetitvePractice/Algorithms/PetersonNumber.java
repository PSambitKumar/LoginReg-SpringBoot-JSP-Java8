package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 28/01/2023 - 11:23 PM
 */
public class PetersonNumber {
    public static void main(String[] args) {
        int num = 145;
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            int rem = temp % 10;
            sum += factorial(rem);
            temp /= 10;
        }
        if (sum == num) {
            System.out.println("Peterson Number");
        } else {
            System.out.println("Not a Peterson Number");
        }
    }

    private static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
