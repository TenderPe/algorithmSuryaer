package com.leetcode;

import java.util.Arrays;

public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i, j;
        int start = 0;   //定义每圈循环从start开始填充元素
        int count = 1;   //要填充的数
        int loop = 0;   //控制画圈的次数 n=5需要画两次圈 最后一个元素不用画 直接填充 n=4直接画两圈即可填充完毕
        while (loop++ < n / 2) {
            j = start;
            for (i = start; i < n - loop; i++) {
                matrix[j][i] = count++;
            }
            for (j = start; j < n - loop; j++) {
                matrix[j][i] = count++;
            }
            for (; i >= loop; i--) {
                matrix[j][i] = count++;
            }
            for (; j >= loop; j--) {
                matrix[j][i] = count++;
            }
            start++;
        }
        if ((n & 1) == 1) {
            matrix[start][start] = count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        int[][] matrix = leetCode59.generateMatrix(5);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
