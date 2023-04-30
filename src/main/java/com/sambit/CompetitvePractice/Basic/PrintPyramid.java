package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 30/04/2023 - 11:38 PM
 */
public class PrintPyramid {
    public static void printPyramid(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
