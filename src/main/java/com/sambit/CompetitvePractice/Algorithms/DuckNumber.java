package com.sambit.CompetitvePractice.Algorithms;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 29/01/2023 - 11:18 PM
 */
public class DuckNumber {
    public static void main(String[] args) {
        int num = 1230;
        int temp = num;
        boolean isDuckNumber = false;
        while (temp > 0) {
            int rem = temp % 10;
            if (rem == 0) {
                isDuckNumber = true;
                break;
            }
            temp /= 10;
        }
        if (isDuckNumber) {
            System.out.println("Duck Number");
        } else {
            System.out.println("Not a Duck Number");
        }
    }
}
