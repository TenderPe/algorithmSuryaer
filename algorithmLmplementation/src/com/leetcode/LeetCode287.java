package com.leetcode;

public class LeetCode287 {
    public static int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            if (fast == slow) {
                break;
            }
            slow = nums[slow];
        }
        slow = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return nums[fast];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        System.out.println(findDuplicate(nums));
    }
}
