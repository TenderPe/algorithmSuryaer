package com.leetcode;

public class LeetCode62 {
    public static int uniquePaths(int m, int n) {
        return process(m, n, m - 1, n - 1);
    }

    public static int process(int m, int n, int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        return process(m, n, i - 1, j) + process(m, n, i, j - 1);
    }

    public static int uniquePaths2(int m, int n) {
        int col = Math.min(m, n);
        int row = col == m ? n : m;
        int[] dp = new int[col];
        dp[0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (i == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[col - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths2(m, n));
    }
}
