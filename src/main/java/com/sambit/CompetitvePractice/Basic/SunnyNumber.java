package com.sambit.CompetitvePractice.Basic;
import java.util.*;

public class SunnyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int N=sc.nextInt();
    }
    static boolean findPerfectSquare(double num) {
        double square_root = Math.sqrt(num);
        return((square_root - Math.floor(square_root)) == 0);
    }
    static void isSunnyNumber(int N) {
        if (findPerfectSquare(N + 1))
            System.out.println("The given number is a sunny number.");
        else
            System.out.println("The given number is not a sunny number.");
    }
}