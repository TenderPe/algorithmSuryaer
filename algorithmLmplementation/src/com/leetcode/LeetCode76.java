package com.leetcode;

public class LeetCode76 {
    public static String minWindow(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen < tlen || tlen == 0) {
            return "";
        }
        int[] windows = new int[58];
        int[] tstr = new int[58];

        for (int i = 0; i < tlen; i++) {
            tstr[t.charAt(i) - 'A']++;
        }

        String res = "";
        int min = slen + 1;
        for (int l = 0, r = 0; r <= slen; ) {
            if (isInclude(windows, tstr)) {
                if ((r - l) < min) {
                    min = r - l;
                    res = s.substring(l, r);
                }
                windows[s.charAt(l) - 'A']--;
                l++;
            } else {
                if (r == slen) {
                    return res;
                }
                windows[s.charAt(r) - 'A']++;
                r++;
            }
        }
        return res;
    }

    public static boolean isInclude(int[] windows, int[] str) {
        for (int i = 0; i < windows.length; i++) {
            if (windows[i] < str[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
