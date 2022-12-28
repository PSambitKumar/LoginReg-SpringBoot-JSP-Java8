package com.sambit.CompetitvePractice.LeetCode;


import java.util.Arrays;

import static java.util.Collections.rotate;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 28/12/2022 - 3:10 PM
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate3(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int start = 0;
        int end = nums.length;
//        First of all Store the First Element in temp.
//        Then shift all the element to right one by one and then store the temp in first index.
//        Repeat this process Kth time.
        while (k > 0) {
            int temp = nums[end - 1];
            for (int i = end - 1; i > start; i--) {
                nums[i] = nums[i - 1];
            }
            nums[start] = temp;
            k--;
        }
    }

    public static void rotate1(int[] nums, int k) {
        int end = nums.length;

//        Make 2 SubArray of Suitable Size
        int[] subArray1 = new int[end - k];
        int[] subArray2 = new int[k];

        for (int i = 0; i < end; i++) {
            if (i < end - k) {
                subArray1[i] = nums[i];
            } else {
                subArray2[i - (end - k)] = nums[i];
            }
        }
        System.out.println("SubArray1" + Arrays.toString(subArray1));
        System.out.println("SubArray2" + Arrays.toString(subArray2));

//        Merge Two SubArray to nums
        for (int i = 0; i < end; i++) {
            if (i < subArray2.length) {
                nums[i] = subArray2[i];
            } else {
                nums[i] = subArray1[i - subArray2.length];
            }
        }
        System.out.println("nums" + Arrays.toString(nums));
    }

    public static void rotate2(int[] nums, int k) {
        int start = 0;
        int count = 0;
        int end = nums.length;
        int endCount = nums.length;
        int[] temp = nums.clone();

        for (int i = end - 1; i >= 0; i--) {
            if (count < k) {
                nums[start] = temp[i];
                start++;
                count++;
            } else {
                nums[endCount - 1] = temp[i];
                endCount--;
            }
        }
    }

    public static void rotate3(int[] nums, int k) {
        int[] tempArr = nums.clone();
        int end = nums.length;

        for (int i = 0; i < end; i++) {
            System.out.println("Array Location : " + nums[(i + k) % end]);
            System.out.println("Value : " + tempArr[i]);
            nums[(i + k) % end] = tempArr[i];
        }
        System.out.println("New Array : " + Arrays.toString(nums));
    }
}
