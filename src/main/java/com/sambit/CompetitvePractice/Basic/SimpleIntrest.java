package com.sambit.CompetitvePractice.Basic;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 30/07/2023 - 11:45 PM
 */
public class SimpleIntrest {

    public static void calculateSimpleIntrest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Principal Amount: ");
        int principalAmount = sc.nextInt();
        System.out.println("Enter the Rate of Interest: ");
        float rateOfInterest = sc.nextFloat();
        System.out.println("Enter the Time Period: ");
        int timePeriod = sc.nextInt();
        float simpleIntrest = (principalAmount * rateOfInterest * timePeriod) / 100;
        System.out.println("Simple Intrest is: " + simpleIntrest);
    }
    public static void main(String[] args) {
        calculateSimpleIntrest();

    }
}
