package com.leetcode;

public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        int[] help = new int[26];
        int res = 0;
        char[] str = s.toCharArray();
        int len = str.length;
        for(int l = 0, r = 0; r < len; r++) {
            if(isHave(str, r, help)) {
                res = Math.max(res, r-l);
                while(str[l] != str[r]) {
                    help[str[l]-'a']--;
                    l++;
                }
                help[str[l]-'a']--;
                l++;
                help[str[r] - 'a']++;
            } else {
                help[str[r] - 'a']++;
            }
        }
        return res;
    }

    public static boolean isHave(char[] str, int r, int[] help) {
        return help[str[r] - 'a'] > 0;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
