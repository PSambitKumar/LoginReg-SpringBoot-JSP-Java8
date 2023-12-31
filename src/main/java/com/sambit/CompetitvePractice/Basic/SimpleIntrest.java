package com.sambit.CompetitvePractice.Basic;

public class SimpleIntrest {

    public static void main(String[] args) {
        int p = 1000;
        int r = 10;
        int t = 2;
        int si = (p * r * t) / 100;
        System.out.println("Simple Intrest is : " + si);

        int ci = (int) (p * Math.pow((1 + r / 100), t));
        System.out.println("Compound Intrest is : " + ci);

        int n = 10;
        int a = 2;
        int d = 3;
        int tn = a + (n - 1) * d;
        System.out.println("Nth term of an AP is : " + tn);


        int n1 = 10;
        int a1 = 2;
        int r1 = 3;
        int tn1 = a1 * (int) Math.pow(r1, n1 - 1);
        System.out.println("Nth term of an GP is : " + tn1);

        int n2 = 10;
        int a2 = 2;
        int d2 = 3;
        int sn = (n2 / 2) * (2 * a2 + (n2 - 1) * d2);
        System.out.println("Sum of n terms of an AP is : " + sn);

        int n3 = 10;
        int a3 = 2;
        int r3 = 3;
        int sn1 = (a3 * (int) (Math.pow(r3, n3) - 1)) / (r3 - 1);
        System.out.println("Sum of n terms of an GP is : " + sn1);

        int n4 = 10;
        int a4 = 2;
        int d4 = 3;
        int tn2 = a4 + (n4 - 1) * d4;
        int sn2 = (n4 / 2) * (a4 + tn2);
        System.out.println("Sum of n terms of an AP is : " + sn2);

        int n5 = 10;
        int a5 = 2;
        int r5 = 3;
        int tn3 = a5 * (int) Math.pow(r5, n5 - 1);
        int sn3 = (a5 * (int) (Math.pow(r5, n5) - 1)) / (r5 - 1);
        System.out.println("Sum of n terms of an GP is : " + sn3);

        int n6 = 10;
        int a6 = 2;
        int d6 = 3;
        int tn4 = a6 + (n6 - 1) * d6;
        int sn4 = (n6 / 2) * (a6 + tn4);
        int an = a6 + (n6 - 1) * d6;
        System.out.println("Sum of n terms of an AP is : " + sn4);

        float P = 10000, R = 5, T = 5;

        // Calculate simple interest
        float SI = (P * T * R) / 100;
        System.out.println("Simple interest = " + SI);

        float CI = (float) (P * (Math.pow((1 + R / 100), T)));
        System.out.println("Compound interest = " + CI);
    }
}
