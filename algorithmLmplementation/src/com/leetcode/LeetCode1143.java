package com.leetcode;

import java.util.Arrays;

public class LeetCode1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[n + 1];


        int leftUp = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    leftUp = 0;
                }
                if (str1[j - 1] == str2[i - 1]) {
                    int temp = dp[j];
                    dp[j] = leftUp + 1;
                    leftUp = dp[j];
                } else {
                    leftUp = dp[j];
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String text1 = "bsbininm", text2 = "jmjkbkjkv";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
