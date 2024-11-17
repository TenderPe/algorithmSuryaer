package com.leetcode.LC150;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-18  00:04
 * @Description: 注意将结果赋值给nums1数组
 */
public class Solution1 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[n+m];
        int i =0, j =0, k =0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                res[k++] = nums1[i];
                i++;
            } else {
                res[k++] = nums2[j];
                j++;
            }
        }
        while(i < m) {
            res[k++] = nums1[i++];
        }
        while(j < n) {
            res[k++] = nums2[j++];
        }
        i = 0;
        for(;i < m+n; i++) {
            nums1[i] = res[i];
        }
        nums1 = res;
        return;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
    }


}
