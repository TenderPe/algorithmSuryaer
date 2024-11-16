package com.leetcode;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class LeetCode70 {
    //暴力递归
    public static int climbStairs(int n) {
        return process(n, 0);
    }

    //总共n阶楼梯  从index位置往上爬有多少种不同的方式
    public static int process(int n, int index) {
        if (index > n) {
            return 0;
        }
        if (index == n) {
            return 1;
        }
        return process(n, index + 1) + process(n, index + 2);
    }

    public static int climbStairsDP(int n) {
        int[] dp = new int[n + 2];
        dp[n + 1] = 0;
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
        System.out.println(climbStairsDP(45));
    }
}
