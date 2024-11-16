package com.leetcode;

import javax.swing.tree.FixedHeightLayoutCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class LeetCode42 {
    public static int trap(int[] height) {
        int len = height.length;
        int[] leftDP = new int[len];
        int[] rightDP = new int[len];
        leftDP[0] = 0;
        rightDP[len - 1] = 0;
        for (int i = 1; i < len - 1; i++) {
            leftDP[i] = Math.max(leftDP[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightDP[i] = Math.max(rightDP[i + 1], height[i + 1]);
        }
        int maxTrap = 0;
        for (int i = 1; i < len - 1; i++) {
            if (leftDP[i] > height[i] && rightDP[i] > height[i]) {
                maxTrap += (Math.min(leftDP[i], rightDP[i]) - height[i]);
            }
        }
        return maxTrap;
    }

    public static int trap2(int[] height) {
        // 对于每个元素i 找到离他左边和右边比他大的元素
        Stack<Integer> stack = new Stack<>();
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int i = 0;
        int max = 0;

        for(; i < len; i++) {
            if(stack.isEmpty()
                    || height[i] <= height[stack.peek()]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()
                        && height[stack.peek()] < height[i]) {
                    int cur = stack.pop();
                    if (!stack.isEmpty()) {
                        max += (Math.min(height[i], height[stack.peek()])-height[cur]) * (i- stack.peek()-1);
                    }
                }
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int n = trap2(height);
        System.out.println(n);
    }
}
