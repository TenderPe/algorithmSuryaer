package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-21  00:02
 * @Description: p是买入的价格  思想： 如果在某一天找到了更低的购买价格（比p低） 那么在未来卖出的时候  利润一定比买入p大
 */
public class Solution7 {
    public int maxProfit(int[] prices) {
        int max = -1;
        int p = prices[0];
        for(int i =0 ;i < prices.length; i++) {
            if (prices[i] < p) {
                p = prices[i];
            }
            max = Math.max(max, prices[i] - p);
        }
        return max;
    }
}
