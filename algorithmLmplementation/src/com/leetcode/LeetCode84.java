package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode84 {
    // 找出任何一个数 其左边比他最小的  其右边比他最小的
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] lefeMin = new int[len];
        int[] rightMin = new int[len];
        List<Integer> list;
        List<Integer> cur;
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || heights[stack.peek().get(0)] < heights[i]) {
                list = new ArrayList<>();
                list.add(i);
                stack.add(list);
            } else if (heights[stack.peek().get(0)] == heights[i]) {
                cur = stack.peek();
                cur.add(i);
            } else {
                while (!stack.isEmpty() && heights[stack.peek().get(0)] > heights[i]) {
                    cur = stack.pop();
                    list = stack.isEmpty() ? null : stack.peek();
                    for (Integer in : cur) {
                        lefeMin[in] = list == null ? -1 : list.get(list.size() - 1);
                        rightMin[in] = i;
                    }
                }
                if (stack.isEmpty() || heights[stack.peek().get(0)] < heights[i]) {
                    list = new ArrayList<>();
                    list.add(i);
                    stack.add(list);
                } else {
                    cur = stack.peek();
                    cur.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            list = stack.isEmpty() ? null : stack.peek();
            for (Integer in : cur) {
                lefeMin[in] = list == null ? -1 : list.get(list.size() - 1);
                rightMin[in] = len;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < len; j++) {
            max = Math.max(max, heights[j] * (rightMin[j] - (lefeMin[j] + 1)));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
