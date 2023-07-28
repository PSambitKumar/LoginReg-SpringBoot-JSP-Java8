package com.sambit.CompetitvePractice.Basic;

public class SecondHighest {
    public void findSecondHighest(int[] array) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i : array) {
            if (i > highest) {
                secondHighest = highest;
                highest = i;
            } else if (i > secondHighest)
                secondHighest = i;
        }
        System.out.println("Highest: " + highest);
    }

    public static void main(String[] args) {
        SecondHighest secondHighest = new SecondHighest();
        secondHighest.findSecondHighest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
