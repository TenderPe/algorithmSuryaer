package com.leetcode;

public class LeetCode300 {
    public static int lengthOfLIS(int[] nums) {
        return process(nums, Integer.MIN_VALUE, 0);
    }

    //nums数组中 从index开始的最长严格递增子序列的长度  n是 0~index 组成的严格递增子序列中最大的数
    public static int process(int[] nums, int n, int index) {
        if (index == nums.length) {
            return 0;
        }
        int p1 = process(nums, n, index + 1);

        int p2 = 0;
        if (nums[index] > n) {
            p2 = 1 + process(nums, nums[index], index + 1);
        }
        return Math.max(p1, p2);
    }


    public static int lengthOfLISDP(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            dp[len][i] = 0;
        }
        int n = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= len; j++) {
                int p1 = dp[i + 1][j];  //数组索引往下走 最大的数还是num中j索引位置的数
                int p2 = 0;
                if (nums[i] > getValue(nums, j)) {
                    p2 = 1 + dp[i + 1][i];
                }
                dp[i][j] = Math.max(p1, p2);
            }
        }
        return dp[0][len];
    }

    public static int getValue(int[] nums, int j) {
        if (j == nums.length) {
            return Integer.MIN_VALUE;
        } else return nums[j];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 5, 8, 7, 4, 1, 5, 255, 4, 101, 18};
        int n = lengthOfLIS(nums);
        System.out.println(n);
        System.out.println(lengthOfLISDP(nums));
    }
}
