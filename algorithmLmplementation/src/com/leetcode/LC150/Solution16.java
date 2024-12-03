package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-12-03  22:58
 * @Description: 对于每个柱子  只需要找到这个柱子左边最高的柱子和右边最高的柱子
 */
public class Solution16 {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftDp = new int[n];
        leftDp[0] = 0;
        for(int i = 1; i < n; i++) {
            leftDp[i] = Math.max(height[i-1], leftDp[i-1]);
        }
        int[] rightDp = new int[n];
        rightDp[n-1] = 0;
        for(int i = n-2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i+1], height[i+1]);
        }
        int res = 0;
        for(int i = 1;  i< n-1; i++) {
            int tmp = Math.min(leftDp[i], rightDp[i]);
            if(height[i] < tmp) {
                res += tmp - height[i];
            }
        }
        return res;
    }
}
