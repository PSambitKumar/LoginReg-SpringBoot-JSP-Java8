package com.sambit.CompetitvePractice.Basic;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 07/03/2023 - 10:08 PM
 */
class Testarray{
    public static void main(String[] args){
        int[] a =new int[5];
        a[0]=10;
        a[1]=20;
        a[2]=70;
        a[3]=40;
        a[4]=50;
        for (int j : a) System.out.println(j);
        System.out.println("Sum of the array is: "+sumTheArray(a));
    }

    public static int sumTheArray(int[] a){
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        return sum;
    }

    public static int sumTheArray(int[] a, int n){
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        return sum;
    }

    public static int displayTheArray(int[] a){
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        return sum;
    }
}
