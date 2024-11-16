package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class LeetCode139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return process(s, set);
    }

    public static boolean process(String s, HashSet<String> set) {
        if (s.equals("")) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                if (process(s.substring(i), set)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreakDP(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList("aaaa", "aaa");
        System.out.println(wordBreak(s, wordDict));
        boolean t = wordBreakDP(s, wordDict);
        System.out.println(wordBreakDP(s, wordDict));
    }
}
