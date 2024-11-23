package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-23  21:43
 * @Description: 准备两个数组  left right left[i]存储的是i的前缀元素的乘积 不包括i元素
 */
public class Solution13 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for(int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i = 0; i < n; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(num));
    }
}
