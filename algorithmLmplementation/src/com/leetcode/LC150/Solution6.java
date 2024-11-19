package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-19  20:16
 * @Description: TODO
 */
public class Solution6 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }

    public void reverse(int[] nums, int l, int r) {
        int i = l;
        int j = r;
        while(i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
