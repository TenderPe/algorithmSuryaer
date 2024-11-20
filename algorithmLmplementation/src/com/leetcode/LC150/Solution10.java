package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-21  00:34
 * 首先大概思路是： max为从索引i可以跳到的最远处  从索引i~max我们寻找到j索引   使得在0~max范围内的所有索引中j是跳的最远的  然后更新max值
 * 继续从j~max找可以跳的最远的索引  一直到nums.length-1 期间步数值加一
 * 所以，下面代码的思路是：刚开始max为索引0处可以跳到的最远值  然后从0~max寻找索引j 使得在0~max范围内的所有索引中j是跳的最远的  然后更新max值
 * 假设索引序为 0 1 2 j j+1 j+2 max max+1 max+2 max+3 jmax   jmax为j可以跳到的最远处
 * 我们已经遍历了 0~max 当遍历到max+1时，可以知道步数要加一了，注意此时i=max+1了  我们如果不执行i--，那么下一次循环i=max+2  如果执行了i-- 下一次循环i=max+1
 * 正好符合 从max+1~jmax开始遍历   因为 j~max我们已经遍历过了
 *
 *res >= nums.length ? 0 : res; 防止[0]情况  因为起始步为1
 */
public class Solution10 {
    public static int jump(int[] nums) {
        int res = 1;
        int max = nums[0];
        int tmp = nums[0];

        for(int i = 0; i < nums.length; i++) {
            if(i <= max) {
                if(i + nums[i] > tmp) {
                    tmp = i + nums[i];
                }
            } else {
                res++;
                max = tmp;
                i--;


            }
        }
        return res >= nums.length ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,1,1};
        System.out.println(jump(nums));
    }
}
