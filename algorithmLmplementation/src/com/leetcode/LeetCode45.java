package com.leetcode;

public class LeetCode45 {
    public static int jump(int[] nums) {
        int len = nums.length;
        int[] rightMax = new int[len];
        rightMax[0] = nums[0];
        int i = 0;
        for (; i < len; i++) {
            if (i == 0) {
                rightMax[i] = nums[0];
                continue;
            }
            if (rightMax[i - 1] >= len - 1) {
                break;
            }
            if (rightMax[i - 1] < i + nums[i]) {
                rightMax[i] = i + nums[i];
            } else {
                rightMax[i] = rightMax[i - 1];
            }
        }
        int n = 0;
        for (int j = 0; j < i; j++) {
            int max = rightMax[j];
            for (int k = j; k < i && k <= rightMax[j]; k++) {
                max = Math.max(max, rightMax[k]);
                if (max == len - 1) {
                    return n + 1;
                }
            }
            n++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        System.out.println(jump(nums));

    }

}
