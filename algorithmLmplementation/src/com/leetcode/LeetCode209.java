package com.leetcode;

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, num = 0, minNumsLength = Integer.MAX_VALUE, numsLength = 0;
        while (j < nums.length) {
            num += nums[j++];
            numsLength++;
            while (num >= target) {
                minNumsLength = Math.min(minNumsLength, numsLength);
                num -= nums[i++];
                numsLength--;
            }
        }
        return minNumsLength == Integer.MAX_VALUE ? 0 : minNumsLength;
    }
}
