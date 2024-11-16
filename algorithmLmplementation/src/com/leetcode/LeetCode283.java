package com.leetcode;

public class LeetCode283 {
    public static void moveZeroes(int[] nums) {
        //两个指针，一个指针指向第一个0元素  另一个指针向后遍历
        int zero = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(zero != -1){
                    nums[zero] = nums[i];
                    nums[i] = 0;
                    zero++;
                }
            }else{
                zero = zero == -1 ? i : zero;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,0,12,0};
        moveZeroes(nums);
    }
}
