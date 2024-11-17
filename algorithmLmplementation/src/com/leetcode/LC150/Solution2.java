package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-18  00:19
 * @Description: TODO
 */
public class Solution2 {
    // 1:注意 空数组 此时left永远为-1
    // 2:当数组中的元素都不是val时 此时val为-1
    // 合并一下 当left为-1时  返回数组的长度
    public int removeElement(int[] nums, int val) {
        int left = -1;
        int right = 0;
        while(right < nums.length) {
            if(nums[right] == val) {
                if(left == -1) {
                    left = right;
                }
                right++;
            } else {
                if(left != -1) {
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
        }
        return left == -1 ? nums.length : left;
    }
}
