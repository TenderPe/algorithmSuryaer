package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-19  20:11
 * @Description: TODO
 */

public class Solution5 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return nums[0];
        }
        int k = 1;
        int tmp = nums[0];
        int i = 1;
        while(i < n) {
            if(nums[i] == tmp) {
                k++;
            } else {
                if(k == 0) {
                    tmp = nums[i];
                    k++;
                } else {
                    k--;
                }
            }
            i++;
        }
        return tmp;
    }
}
