package com.leetcode;

public class LeetCode32 {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        int max = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                //碰到右括号了
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? 2 + dp[i - 2] : 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = i - dp[i - 1] - 2 >= 0 ? 2 + dp[i - 1] + dp[i - dp[i - 1] - 2] : 2 + dp[i - 1];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
