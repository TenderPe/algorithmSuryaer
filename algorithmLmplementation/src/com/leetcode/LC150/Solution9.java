package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-21  00:14
 * @Description: max为当前可以跳到的最大位置  然后在每个索引处判断 如果max小于 i 那说明当前不能跳到索引i处 返回false 否则 更新max值 也就是更新现在可以跳到的最远位置
 */
public class Solution9 {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(i > max) { // 初始可以跳到的最大位置为 nums[0]
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
