package com.sambit.CompetitvePractice.LeetCode.Problems;

import java.util.Iterator;

/**
 * @Project : Registration
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 29/12/2022 - 6:30 PM
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int k = 9;
        int[] result = twoSum(nums, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 1; j < result.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
