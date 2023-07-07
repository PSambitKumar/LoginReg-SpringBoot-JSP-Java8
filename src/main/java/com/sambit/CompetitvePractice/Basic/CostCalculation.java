package com.sambit.CompetitvePractice.Basic;

import java.util.Scanner;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 06/05/2023 - 11:44 PM
 */
public class CostCalculation {
    public static void main(String[] args) {
        int unitCost = 100, totalCost = 0, quantity = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the Quantity of Units You Want to Purchase : ");
            quantity = scanner.nextInt();
            totalCost = quantity * unitCost;
            if (totalCost > 1000)
                totalCost = totalCost - (totalCost / 10);
            System.out.println("Total Cost : " + totalCost);
        } catch (Exception e) {
            System.out.println("Please Enter a Valid Number");
        }
    }
}
