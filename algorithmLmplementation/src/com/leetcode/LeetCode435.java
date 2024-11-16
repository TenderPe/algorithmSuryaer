package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode435 {

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int end = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
            } else {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };
        System.out.println(eraseOverlapIntervals(arr));
    }
}
