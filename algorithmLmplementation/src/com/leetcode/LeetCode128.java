package com.leetcode;

import java.util.HashSet;

/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LeetCode128 {
    public static int longestConsecutive(int[] nums) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int n = num;
                while (set.contains(n)) {
                    n++;
                }
                max = Math.max(max, n - num);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(longestConsecutive(nums));
    }
}
