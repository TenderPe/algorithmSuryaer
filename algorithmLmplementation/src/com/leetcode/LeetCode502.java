package com.leetcode;

import java.util.PriorityQueue;

public class LeetCode502 {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Integer[][] arr = new Integer[capital.length][2];
        for (int i = 0; i < capital.length; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        PriorityQueue<Integer[]> sheap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer[]> mheap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < capital.length; i++) {
            sheap.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!sheap.isEmpty() && sheap.peek()[0] <= w) {
                mheap.add(sheap.poll());
            }
            if (!mheap.isEmpty()) {
                w += mheap.poll()[1];
            }
        }
        return w;
    }

    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = new int[]{1, 2, 3};
        int[] capital = new int[]{0, 1, 2};
        int r = findMaximizedCapital(k, w, profits, capital);
        System.out.println(r);
    }
}
