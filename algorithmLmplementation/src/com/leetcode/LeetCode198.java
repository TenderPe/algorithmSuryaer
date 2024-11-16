package com.leetcode;

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class LeetCode198 {
    public static int rob(int[] nums) {
        return process(nums, 0);
    }

    //index位置做决策 选不选index index~nums.length-1 所能获得的最大金额
    public static int process(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int p1 = nums[index] + process(nums, index + 2);
        int p2 = process(nums, index + 1);
        return Math.max(p1, p2);
    }

    public static int robDP(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 2];
        dp[len] = 0;
        dp[len + 1] = 0;
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(nums));
        System.out.println(robDP(nums));
    }
}
