package com.leetcode;

import java.util.*;

public class LeetCode30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for(int i = 0; i < w; i++) {
            Map<String, Integer> curMap = new HashMap<>();
            for(int j = i; j+m*w <= n; j += w) {
                String cur = s.substring(j, j+w);
                if(j >= i+m*w) {
                    String rm = s.substring(j - w*(m-1), j - w*(m-1)+w);
                    if(curMap.get(rm) == 1) {
                        curMap.remove(rm);
                    } else {
                        curMap.put(rm, curMap.get(rm)-1);
                    }
                }
                curMap.put(cur, curMap.getOrDefault(cur, 0) +1);
                if(map.containsKey(cur) && Objects.equals(map.get(cur), curMap.get(cur)) && map.equals(curMap)) {
                    res.add(j - w*(m-1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
}
