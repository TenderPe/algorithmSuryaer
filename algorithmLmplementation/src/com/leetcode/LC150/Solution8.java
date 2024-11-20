package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-21  00:07
 * @Description: 只要有钱就卖  并且更新买入价格   如果碰到更低的买入价格  则放弃买p 进而买最低的
 */
public class Solution8 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int p = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > p) {
                max += (prices[i] - p);
                p = prices[i];
            } else {
                p = prices[i];
            }
        }
        return max;
    }
}
