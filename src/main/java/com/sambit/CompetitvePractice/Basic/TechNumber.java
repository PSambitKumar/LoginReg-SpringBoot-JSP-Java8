package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 20/07/2023 - 4:06 PM
 */
public class TechNumber {

    public static void main(String[] args) {
        int num = 123;
        int temp = num;
        int sum = 0;
        while (temp > 0) {
            int rem = temp % 10;
            sum += rem;
            temp /= 10;
        }
        if (num % sum == 0) System.out.println("Tech Number");
        else System.out.println("Not a Tech Number");
    }
}
