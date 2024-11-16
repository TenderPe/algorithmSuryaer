package com.leetcode;

import java.util.*;

public class LeetCode215 {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int num : nums) {
            queue.add(num);
        }
        int res = -1;
        for (int i = 0; i <= k; i++) {
            res = queue.poll();
        }
        return res;
    }

    public static int findKthLargest2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int num : nums) {
            res.add(num);
        }
        return process(res, k);
    }

    private static int process(List<Integer> nums, int k) {
        int l = 0, r = nums.size() - 1;
        int mid = l + (r - l) >> 1;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> midArr = new ArrayList<>();
        for (int i = 0; i < r - l + 1; i++) {
            if (nums.get(i) == nums.get(mid)) {
                midArr.add(nums.get(i));
            } else if (nums.get(i) > nums.get(mid)) {
                right.add(nums.get(i));
            } else {
                left.add(nums.get(i));
            }
        }
        if (k <= right.size()) {
            return process(right, k);
        } else if ((nums.size() - left.size()) < k) {
            return process(left, k);
        } else {
            return nums.get(mid);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest2(nums, 2));
    }
}
