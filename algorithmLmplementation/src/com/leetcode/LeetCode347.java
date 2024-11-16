package com.leetcode;

import java.util.*;

public class LeetCode347 {
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        ArrayList<Integer>[] a = new ArrayList[4];
        return res;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];

        for (Integer in : map.keySet()) {
            Integer num = map.get(in);
            // num是in这个数出现的频率
            if (list[num] == null) {
                List<Integer> cur = new ArrayList<>();
                cur.add(in);
                list[num] = cur;
            } else {
                list[num].add(in);
            }
        }

        int[] res = new int[k];
        for (int j = 0, i = nums.length; i >= 0 && j < k; i--) {
            if (list[i] != null) {
                for (Integer integer : list[i]) {
                    res[j++] = integer;
                    if (j >= k) {
                        break;
                    }
                }
            }
        }

        return res;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
