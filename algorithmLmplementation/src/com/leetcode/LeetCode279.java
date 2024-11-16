package com.leetcode;

public class LeetCode279 {

    public static int numSquares(int n) {
        return process(n);
    }

    public static int process(int n) {
        if (n == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, process(n - i * i) + 1);
        }
        return min;
    }

    public static int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 36;
        System.out.println(numSquares(n));
        System.out.println(numSquaresDP(n));
    }
}
