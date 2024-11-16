package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class LeetCode118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) {
            return lists;
        }
        if (numRows == 1) {
            lists.add(new ArrayList<>());
            lists.get(0).add(1);
            return lists;
        }
        lists = generate(numRows - 1);
        List<Integer> curList = new ArrayList<>();
        curList.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            curList.add(lists.get(numRows - 2).get(i - 1) + lists.get(numRows - 2).get(i));
        }
        curList.add(1);
        lists.add(curList);
        return lists;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) {
            return lists;
        }

        lists.add(new ArrayList<>());
        lists.get(0).add(1);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            List<Integer> preList = lists.get(i - 2);
            curList.add(1);
            for (int j = 1; j < i - 1; j++) {
                curList.add(preList.get(j - 1) + preList.get(j));
            }
            curList.add(1);
            lists.add(curList);
        }
        return lists;
    }

    public static void main(String[] args) {
        int numRows = 4;
        List<List<Integer>> lists = generate(numRows);
        List<List<Integer>> lists2 = generate2(numRows);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(Arrays.toString(lists.get(i).toArray()));
        }

        for (int i = 0; i < lists2.size(); i++) {
            System.out.println(Arrays.toString(lists2.get(i).toArray()));
        }
    }
}
