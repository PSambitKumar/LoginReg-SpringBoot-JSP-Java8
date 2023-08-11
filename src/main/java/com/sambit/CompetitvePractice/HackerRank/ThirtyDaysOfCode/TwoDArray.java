package com.sambit.CompetitvePractice.HackerRank.ThirtyDaysOfCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 28/11/2022 - 10:35 AM
 */
public class TwoDArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        bufferedReader.close();
        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = 0;
                sum += arr[i][j];
                sum += arr[i][j + 1];
                sum += arr[i][j + 2];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j];
                sum += arr[i + 2][j + 1];
                sum += arr[i + 2][j + 2];
                sumList.add(sum);
            }
        }
        int max = sumList.get(0);
        for (int i = 1; i < sumList.size(); i++) {
            if (sumList.get(i) > max) {
                max = sumList.get(i);
            }
        }
        System.out.println(max);
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        bufferedReader.close();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
