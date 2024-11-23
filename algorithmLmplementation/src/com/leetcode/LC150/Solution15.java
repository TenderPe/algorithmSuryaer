package com.leetcode.LC150;

import java.util.Arrays;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-23  23:07
 * @Description: 首先tmp数组初始化为全1数组 因为每个孩子最低有一个糖果
 * 左规则：当 ratings[i−1]<ratings[i] 时，i 号学生的糖果数量将比 i−1 号孩子的糖果数量多。
 * 右规则：当 ratings[i]>ratings[i+1] 时，i 号学生的糖果数量将比 i+1 号孩子的糖果数量多。
 * 我们先进行左规则  如果ratings[i] > ratings[i-1]  则将i孩子的糖果数量在i-1孩子的基础上加一
 * 右规则：当ratings[i] > ratings[i+1]  时 我们需要增加i孩子的糖果数量  但是由于先前已经遍历了一遍  所以
 * i孩子的糖果可能已经比i+1孩子的多了  如果真是这样  那什么都不做  否则在i+1孩子的基础上 将i孩子的糖果加一
 *
 */
public class Solution15 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] tmp = new int[n];
        Arrays.fill(tmp, 1);
        int res = 0;
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                tmp[i] = tmp[i-1] + 1;
            }
        }
        for(int i = n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                if(tmp[i] <= tmp[i+1]) {
                    tmp[i] = tmp[i+1] + 1;
                }
            }
            res += tmp[i];
        }
        res += tmp[n-1];
        return res;
    }
}
