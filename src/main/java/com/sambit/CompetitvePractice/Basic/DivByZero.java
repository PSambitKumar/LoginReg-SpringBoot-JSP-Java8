package com.sambit.CompetitvePractice.Basic;

class DivByZero {
    public static void main(String args[])
    {
        int var1 = 15;
        int var2 = 5;
        int var3 = 0;
        int ans1 = var1 / var2;

        int ans2 = var1 / var3;

        System.out.println("Division of va1 by var2 is: " + ans1);
        System.out.println("Division of va1 by var3 is: " + ans2);
    }
    public class Accumulator {
        private int value = 0;
        public int accumulate(int x) {
            value += x;
            return value;
        }
    }
}
