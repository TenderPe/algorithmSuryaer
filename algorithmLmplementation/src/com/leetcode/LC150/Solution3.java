package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-18  00:24
 * @Description: 没有特殊要考虑的
 */
public class Solution3 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return n;
        }
        int left = 1;
        int tmp = nums[0];
        int right = 1;
        while(right < n) {
            if(nums[right] == tmp) {
                right++;
            } else {
                nums[left] = nums[right];
                tmp = nums[right];
                left++;
                right++;
            }
        }
        return left;

    }
}
