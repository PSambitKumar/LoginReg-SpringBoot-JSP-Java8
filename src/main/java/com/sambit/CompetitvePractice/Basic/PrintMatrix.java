package com.sambit.CompetitvePractice.Basic;

import java.util.Scanner;

public class PrintMatrix {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        for(int j=0;j<mat[0].length;j++) {
            if(j% 2 == 0) {
                for (int[] ints : mat) {
                    System.out.print(ints[j] + " ");
                }
            } else {
                for(int i=mat.length-1;i>=0;i--) {
                    System.out.print(mat[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
