package com.leetcode.LC150;

import java.util.Arrays;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-22  00:13
 * @Description: H指数  首先：H指数必不可能超过数组大小  将数组排序  H指数初始设为n（数组大小）  然后遍历数组  如果一个数num小于n 那么H指数必不能为n 但是可能为n-1
 * 遍历过程中  如果一个数 小于n-1 那么h指数必不能为n-1  最多只能是n-2
 * 因为数组是有序的  所以当一个数num大于等于n  那么后面的数字都大于等于n  此时n就是h指数了
 */
public class Solution11 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int k = n;
        Arrays.sort(citations);
        for(int num : citations) {
            if(num < k) {
                k--;
            }
        }
        return k;
    }
}
