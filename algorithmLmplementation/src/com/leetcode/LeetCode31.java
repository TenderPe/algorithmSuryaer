package com.leetcode;

import java.util.Arrays;

public class LeetCode31 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int n = len - 1;
        int i, j;
        while (n > 0) {
            if (nums[n - 1] < nums[n]) {
                break;
            }
            n--;
        }
        if (n == 0) {
            // 此时数组是最大序
            i = 0;
            j = len - 1;
            while (i < j) {
                n = nums[j];
                nums[j] = nums[i];
                nums[i] = n;
                i++;
                j--;
            }
        } else {
            // 当前n-1位置就是我们需要调换的位置
            for (i = n; i < len; i++) {
                if (nums[i] < nums[n - 1]) {
                    break;
                }
            }

            j = nums[i - 1];
            nums[i - 1] = nums[n - 1];
            nums[n - 1] = j;

            i = n;
            j = len - 1;
            while (i < j) {
                n = nums[j];
                nums[j] = nums[i];
                nums[i] = n;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
