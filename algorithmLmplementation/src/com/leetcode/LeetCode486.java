package com.leetcode;

import java.util.Arrays;
import java.util.List;

public class LeetCode486 {
    public static List<Integer> predictTheWinner(int[] nums) {
        return List.of(f(nums, 0, nums.length - 1), s(nums, 0, nums.length - 1));
    }

    public static int f(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        return Math.max(nums[start] + s(nums, start + 1, end), nums[end] + s(nums, start, end - 1));
    }

    public static int s(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        return Math.min(f(nums, start + 1, end), f(nums, start, end - 1));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 233, 7};
        List<Integer> list = predictTheWinner(nums);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
