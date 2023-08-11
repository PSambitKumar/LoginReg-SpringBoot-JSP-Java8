package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 05/02/2023 - 11:07 PM
 */
public class EvilNumber {
    public static void main(String[] args) {
        int num = 23;
        int count = 0;
        int temp = num;
        while (temp > 0) {
            int rem = temp % 2;
            if (rem == 1) {
                count++;
            }
            temp /= 2;
        }
        if (count % 2 == 0) {
            System.out.println("Evil Number");
        } else {
            System.out.println("Not an Evil Number");
        }
    }
}
