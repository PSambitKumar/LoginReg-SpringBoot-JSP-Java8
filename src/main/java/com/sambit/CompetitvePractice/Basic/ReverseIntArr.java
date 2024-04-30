package com.sambit.CompetitvePractice.Basic;

import java.util.*;

/**
 * @Project : Registraion
 * @Author: Sambit Kumar Pradhan
 * @Date: 30-Apr-2024 : 6:12 PM
 */

public class ReverseIntArr {

    ReverseIntArr(){}

    public static int[] reverseArr(int[] arr) {
        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        List<Integer> intList = Arrays.asList(boxedArray);
        Collections.reverse(intList);
        return intList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] reverseArr1(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = temp;
        }
        return arr;
    }

    public static int[] reverseArr2(int[] arr) {
        int length = arr.length;
        int[] reversedArr = new int[length];
        for (int i = 0; i < length; i++) {
            reversedArr[length - i - 1] = arr[i];
        }
        return reversedArr;
    }

    public static int[] reverseArr3(int[] arr) {
        int length = arr.length;
        int[] reversedArr = new int[length];
        int i = 0;
        int j = length - 1;

        while (i < length) {
            reversedArr[i] = arr[j];
            i++;
            j--;
        }

        return reversedArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        System.out.println(reverseArr(arr));
        System.out.println(reverseArr1(arr));
        System.out.println(reverseArr2(arr));
        System.out.println(reverseArr3(arr));
    }
}
