package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode763 {
    public static List<Integer> partitionLabels(String s) {
        List<StringBuilder> list = new ArrayList<>();
        char[] str = s.toCharArray();
        int k = 0;
        int[] flag = new int[26];
        for (int i = 0; i < 26; i++) {
            flag[i] = -1;
        }
        for (int i = 0; i < str.length; i++) {
            if (flag[str[i] - 'a'] == -1) {
                StringBuilder builder = new StringBuilder();
                builder.append(str[i]);
                list.add(builder);
                flag[str[i] - 'a'] = list.size() - 1;
            } else {
                // 这个字母以前出现过
                int l = flag[str[i] - 'a'];
                StringBuilder builder = new StringBuilder();
                for (int j = l; j < list.size(); j++) {
                    StringBuilder builder1 = list.get(j);
                    for (char c : builder1.toString().toCharArray()) {
                        flag[c - 'a'] = l;
                    }
                    builder.append(builder1);
                }
                for (int j = l; j < list.size(); ) {
                    list.remove(j);
                }
                builder.append(str[i]);
                list.add(builder);
            }
        }
        List<Integer> res = new ArrayList<>(list.size());
        for (StringBuilder builder : list) {
            res.add(builder.length());
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
