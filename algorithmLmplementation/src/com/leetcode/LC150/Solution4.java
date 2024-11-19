package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-19  19:35
 * @Description: TODO
 */
// 双指针  r向前遍历  l永远指向将要覆盖的元素
// 注意 如果l=-1 不要产生任何覆盖动作  也不要操作l  因为l=-1表示一种符合题意的情况  而l表示需要覆盖的元素  如果增加l 就会出错
// 注意最后返回l 为 -1的情况
public class Solution4 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int k = 2;
        int l = -1; // 永远指向将要覆盖的元素
        int r = 1;
        int tmp = nums[0];
        int t = 1;
        while(r < n) {
            if(nums[r] == tmp) {
                if (t < k) {
                    if(l > -1) {
                        nums[l] = nums[r];
                        l++;
                    }
                    t++;
                    r++;
                } else {
                    if (l == -1) {
                        l = r;
                    }
                    r++;
                }
            } else {
                t = 1;
                tmp = nums[r];
                if(l > -1) {
                    nums[l] = tmp;
                    l++;
                }
                r++;
            }
        }
        return l == -1 ? n : l;
    }
}
