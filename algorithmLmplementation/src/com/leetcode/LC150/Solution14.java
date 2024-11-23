package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-23  22:08
 * @Description: 假设 -2 -2 -2 3 3 是gas[i]-cost[i]的数组
 * 首先 如果数组和 >= 0则存在解  否则不存在解
 * 其次我们的目标是找到最大子数组和 并且返回开头的元素，所以从后面开始遍历  如果数组和>max 记录下当前索引
 */
public class Solution14 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int index = -1;
        int tmp = 0;
        int max = 0;
        for(int i = n-1; i >= 0; i--) {
            tmp += gas[i]-cost[i];
            if(tmp >= max) {
                max = tmp;
                index = i;
            }
        }
        return tmp >= 0 ? index : -1;
    }
}
