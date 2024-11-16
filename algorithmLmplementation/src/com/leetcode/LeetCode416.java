package com.leetcode;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
public class LeetCode416 {
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if ((total & 1) == 1) {
            return false;
        }
        return process(nums, total >> 1, 0);
    }

    public static boolean process(int[] nums, int target, int index) {
        if (index == nums.length) {
            return target == 0;
        }
        boolean f1 = process(nums, target - nums[index], index + 1);
        boolean f2 = process(nums, target, index + 1);

        return f1 || f2;
    }

    public static boolean canPartitionDP(int[] nums) {
        int len = nums.length;
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += nums[i];
        }
        if ((total & 1) == 1) {
            return false;
        }

        int target = total >> 1;

        boolean[][] dp = new boolean[len + 1][target + 1];
        dp[len][0] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i + 1][j] || getValue(dp, j - nums[i], i + 1);
            }
        }
        return dp[0][target];
    }

    public static boolean getValue(boolean[][] dp, int j, int i) {
        if (j < 0) {
            return false;
        }
        return dp[i][j];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 4, 5};
        boolean t = canPartitionDP(nums);
        System.out.println(canPartitionDP(nums));
        System.out.println(canPartition(nums));
    }
}
