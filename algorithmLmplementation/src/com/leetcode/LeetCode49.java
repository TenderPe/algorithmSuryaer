package com.leetcode;

import java.util.*;

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class LeetCode49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 1) {
            res.add(Arrays.asList(strs));
            return res;
        }
        int n = 0;  //res的数组索引

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String str = new String(chs);

            if (map.get(str) != null) {
                res.get(map.get(str)).add(strs[i]);
            } else {
                map.put(str, n++);
                res.add(new ArrayList<String>());
                res.get(n - 1).add(strs[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);

    }
}
