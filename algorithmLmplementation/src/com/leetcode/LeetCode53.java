package com.leetcode;

public class LeetCode53 {
    // 递归版本
    public static int maxSubArray(int[] nums) {
        // 结果等于以某一个索引的数结尾的连续子数组
        // 对于索引i，以其为结尾的最大连续子数组等于
        // max(max, SubArr(i-1)+nums[i])
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, process(nums, i));
        }
        return max;
    }

    public static int process(int[] nums, int n) {
        if (n == 0) {
            return nums[n];
        }
        return Math.max((process(nums, n - 1) + nums[n]), nums[n]);
    }

    // 动态规划
    public static int maxSubArray2(int[] nums) {
        int[] maxArray = new int[nums.length];
        maxArray[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxArray[i] = Math.max((maxArray[i - 1] + nums[i]), nums[i]);
            if (max < maxArray[i]) {
                max = maxArray[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }
}
