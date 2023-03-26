package com.sambit.CompetitvePractice.Basic;

public class MultiplicationTable {
    public static void multiplicationTable(int n) {
        int result = 0;
        for (int i = 1; i <= 10; i++) {
            result = n * i;
            System.out.println(n + " * " + i + " = " + result);
        }
    }

    public static void main(String[] args) {
        multiplicationTable(5);
    }
}
