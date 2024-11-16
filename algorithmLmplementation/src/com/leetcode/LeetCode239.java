package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            addLastDeque(deque, nums, i);
        }
        res[0] = nums[deque.getFirst()];
        int l = 0;
        int r = k-1;
        for (int i = 1; i < nums.length - k + 1; i++) {
            r += 1;
            addLastDeque(deque, nums, r);
            l += 1;
            addFirstDeque(deque, nums, i);
            res[i] = nums[deque.getFirst()];
        }
        return res;
    }

    private static void addFirstDeque(Deque<Integer> deque, int[] nums, int i) {
        if (deque.size() == 0) {
            return;
        }
        while (deque.size() != 0 && deque.getFirst() < i) {
            deque.removeFirst();
        }
    }

    // 向双端队列尾部添加元素
    public static void addLastDeque(Deque<Integer> deque, int[] nums, int i) {
        if (deque.size() == 0) {
            deque.addLast(i);
            return;
        }
        while (deque.size() != 0 && nums[deque.getLast()] <= nums[i]) {
            deque.removeLast();
        }
        deque.addLast(i);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
    }
}
