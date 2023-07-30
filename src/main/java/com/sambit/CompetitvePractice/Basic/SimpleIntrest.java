package com.sambit.CompetitvePractice.Basic;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 30/07/2023 - 11:45 PM
 */
public class SimpleIntrest {
    public static void main(String[] args) {
        float p, t, r, SI;
        System.out.println("Program to calculate Simple Interest" );
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give the Principle Amount");
        p= sc.nextFloat();
        System.out.println("Please give the Time Duration");
        t= sc.nextFloat();
        System.out.println("Please give the Rate of Interest");
        r= sc.nextFloat();
        SI = (p * t * r) / 100;
        System.out.printf("Simple Interest = %.2f",SI);
    }
}
