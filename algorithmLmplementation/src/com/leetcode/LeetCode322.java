package com.leetcode;

import java.util.Arrays;

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。
 */
public class LeetCode322 {
    public static int coinChange(int[] coins, int amount) {
        return process(coins, amount);
    }

    //index及其以后的硬币自由搭配，组成amount的需要多少硬币
    //用coins里的硬币组成anount，最少的硬币个数是多少
    public static int process(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int nums = process(coins, amount - coins[i]);
            if (nums == -1) {
                continue;
            }
            min = Math.min(min, nums + 1);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int nums = getValue(dp, i - coins[j]);
                if (nums == -1) {
                    continue;
                }
                min = Math.min(min, nums + 1);
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
            min = Integer.MAX_VALUE;
        }
        return dp[amount];
    }

    public static int getValue(int[] dp, int i) {
        if (i < 0) {
            return -1;
        }
        return dp[i];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChangeDP(coins, amount));

    }
}
