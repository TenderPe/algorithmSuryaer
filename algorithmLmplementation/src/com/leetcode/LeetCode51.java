package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode51 {
    public static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        int[] record = new int[n];
        process(0, record, n);
        return res;
    }

    public static void process(int i, int[] record, int n) {
        if (i == n) {
            List<String> so = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                char[] ch = new char[n];
                for (int j = 0; j < n; j++) {
                    if (j == record[k]) {
                        ch[j] = 'Q';
                    } else {
                        ch[j] = '.';
                    }
                }
                String st = String.valueOf(ch);
                so.add(st);
            }
            res.add(so);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isVaild(record, i, j)) {
                record[i] = j;
                process(i + 1, record, n);
            }
            continue;
        }
    }

    public static boolean isVaild(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(k - i) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
