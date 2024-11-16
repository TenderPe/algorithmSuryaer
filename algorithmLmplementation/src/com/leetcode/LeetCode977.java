package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * 首先寻找绝对值最小的元素索引设为i
 * 之后i左边的元素为一队  i右边的元素为1队，并且起始索引为j（i+1）
 * 然后分别比较i和j指向的元素的绝对值大小，如果i指向的元素绝对值小，则将i指向元素的平方放入新数组，之后i--，否则j指向元素
 * 的平方放入新数组，j++，之后可能会碰到一种情况，i指向的最后一个元素（索引为0）已经放入新数组，但是j所在队还有元素未放入
 * 新数组，所以，需要遍历j所在队，将其所有元素依次放入新数组（因为原数组是非降序排列）*/
public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        int min_num = 99999;
        int min_num_idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < min_num) {
                min_num = Math.abs(nums[i]);
                min_num_idx = i;
            }
        }
        int[] newNums = new int[nums.length];
        int k = 0;
        int i = min_num_idx;
        int j = i + 1;
        while (i >= 0 && j < nums.length) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                newNums[k++] = nums[i] * nums[i];
                i--;
            } else {
                newNums[k++] = nums[j] * nums[j];
                j++;
            }
        }
        while (i >= 0) {
            newNums[k++] = nums[i] * nums[i];
            i--;
        }
        while (j < nums.length) {
            newNums[k++] = nums[j] * nums[j];
            j++;
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3};
        System.out.println(Arrays.toString(new LeetCode977().sortedSquares(nums)));
    }
}
