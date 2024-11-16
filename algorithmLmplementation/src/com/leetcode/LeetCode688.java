package com.leetcode;

public class LeetCode688 {
    //暴力递归版本
    public static double knightProbability(int n, int k, int row, int column) {
        double totalPro = Math.pow(8, k);
        long surviveNum = process(n, k, row, column);

        return surviveNum / totalPro;
    }

    //棋盘是n*n 骑士当前在row行 column列 走k步 生存下来的次数
    public static long process(int n, int k, int row, int column) {
        if (row < 0 || row > n - 1 || column < 0 || column > n - 1) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        return process(n, k - 1, row - 1, column - 2) + process(n, k - 1, row - 2, column - 1)
                + process(n, k - 1, row - 2, column + 1) + process(n, k - 1, row - 1, column + 2)
                + process(n, k - 1, row + 1, column + 2) + process(n, k - 1, row + 2, column + 1)
                + process(n, k - 1, row + 2, column - 1) + process(n, k - 1, row + 1, column - 2);
    }

    //动态规划版本
    public static double knightProbabilityDP(int n, int k, int row, int column) {
        double totalPro = Math.pow(8, k);
        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int t = 1; t <= k; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j][t] += getValue(dp, i - 1, j - 2, t - 1, n);
                    dp[i][j][t] += getValue(dp, i - 2, j - 1, t - 1, n);
                    dp[i][j][t] += getValue(dp, i - 2, j + 1, t - 1, n);
                    dp[i][j][t] += getValue(dp, i - 1, j + 2, t - 1, n);
                    dp[i][j][t] += getValue(dp, i + 1, j + 2, t - 1, n);
                    dp[i][j][t] += getValue(dp, i + 2, j + 1, t - 1, n);
                    dp[i][j][t] += getValue(dp, i + 2, j - 1, t - 1, n);
                    dp[i][j][t] += getValue(dp, i + 1, j - 2, t - 1, n);
                }
            }
        }
        double surviveNum = dp[row][column][k];
        return surviveNum / totalPro;
    }

    public static double getValue(double[][][] dp, int row, int column, int k, int n) {
        if (row < 0 || row > n - 1 || column < 0 || column > n - 1) {
            return 0;
        }
        return dp[row][column][k];

    }

    public static void main(String[] args) {
        int n = 8;
        int k = 30;
        int row = 6;
        int column = 4;
        System.out.println(knightProbabilityDP(n, k, row, column));
        //System.out.println(knightProbability(n, k, row, column));
    }
}
