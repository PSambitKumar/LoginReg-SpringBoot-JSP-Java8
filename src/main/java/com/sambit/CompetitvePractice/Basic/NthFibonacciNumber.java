package com.sambit.CompetitvePractice.Basic;

import java.util.Scanner;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 29-Aug-2023 : 5:54 PM
 */

public class NthFibonacciNumber {

    public static int findNthFibonacciNumber1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Nth Location?");
        int location = scanner.nextInt();

        int x = 0;
        int y = 1;
        int sum;

        if (location == 0)
            return x;

        int count = 0;
        do {
            sum = x + y;
            x = y;
            y = sum;
            count++;
        }while (location != count);
        return x;
    }

    public static void main(String[] args) {
        System.out.println(findNthFibonacciNumber1());
    }
}
