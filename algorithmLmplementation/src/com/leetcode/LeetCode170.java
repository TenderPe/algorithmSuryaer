package com.leetcode;

import java.util.Arrays;

public class LeetCode170 {
    public static int reversePairs(int[] record) {
        if (record == null || record.length < 2) {
            return 0;
        }
        return portion(record, 0, record.length - 1);
    }

    public static int portion(int[] record, int i, int j) {
        if (i == j) {
            return 0;
        }
        int mid = i + ((j - i) >> 1);
        return portion(record, i, mid) + portion(record, mid + 1, j) + merge(record, i, mid, j);
    }

    public static int merge(int[] record, int i, int mid, int j) {
        int[] help = new int[j - i + 1];
        int one = mid;
        int two = j;
        int k = j - i;
        int r = 0;
        while (one >= i && two >= (mid + 1)) {
            r += record[one] > record[two] ? (two - (mid + 1) + 1) : 0;
            help[k--] = record[one] > record[two] ? record[one--] : record[two--];
        }
        while (one >= i) {
            help[k--] = record[one--];
        }
        while (two >= mid + 1) {
            help[k--] = record[two--];
        }
        for (int l = 0; l < help.length; l++) {
            record[i + l] = help[l];
        }
        return r;
    }

    public static void main(String[] args) {
        int[] record = new int[]{};
        System.out.println(reversePairs(record));
    }
}
