package com.sambit.CompetitvePractice.FunctionalInterface;

interface DisplayData{
    int displayData(int x);
}

class Example2 {
    public static void main(String[] args) {
        DisplayData display = (x) -> x*x;
        System.out.println(display.displayData(12));
    }
}
