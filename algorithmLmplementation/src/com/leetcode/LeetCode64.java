package com.leetcode;

public class LeetCode64 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int col = Math.min(m, n);
        int row = col == m ? n : m;

        int[] dp = new int[col];
        dp[0] = grid[0][0];
        for (int k = 1; k < col; k++) {
            dp[k] = dp[k - 1] + grid[0][k];
        }
        for (int i = 1; i < row; i++) {
            dp[0] = grid[i][0] + dp[0];
            for (int j = 1; j < col; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
