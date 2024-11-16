package com.leetcode;

import java.util.Arrays;

public class LeetCode135 {
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        Arrays.fill(left, 1);
        int[] right = new int[len];
        Arrays.fill(right, 1);
        int i = 1;
        // A B    B>A 左规则   A>B右规则
        for(; i < len; i++) {
            if(ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            }
        }
        for(i = len-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] + 1;
            }
        }
        int res = 0;
        for(i = 0; i < len; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,87,87,87,2,1};
        System.out.println(candy(nums));
    }
}
