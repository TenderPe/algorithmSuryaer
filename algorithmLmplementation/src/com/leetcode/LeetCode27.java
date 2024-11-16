package com.leetcode;

/*
 * 设置两个指针，一个指针指向当前将要处理的元素j，另一个指向下一个将要赋值的位置i，刚开始时j不断向前遍历，如果j指向的数组中元素不等于val
 * i也向前遍历，当遇到第一个等于val的元素时，i要停止遍历，这主要使用t = false来实现，接下来如果j遍历到不等于val的元素时，需要判断
 * j是否和i指向同一位置，如果不是同一位置，我们需要将当前j所指向元素移动到i处，并将i向前移动

 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int i = 0; //指向数组中可以插入的地方
        boolean t = true;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                if (i != j) {
                    nums[i] = nums[j];
                    ++i;
                }
                if (t) {
                    ++i;
                }
            } else {
                t = false;
            }
        }
        return i;
    }

    /*
     * 注意一点，当j和i无论是否指向同一位置，我们都可以执行nums[i] = nums[j] 只不过i等于j时 做的是无用功*/
    public int removeElement2(int[] nums, int val) {
        int i = 0; //指向数组中可以插入的地方
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                ++i;
            }
        }
        return i;
    }

    /*
     * 优化removeElement和* 优化removeElement2的i j指针最坏情况下都遍历了一次数组
     * * 优化removeElement3 的i和j指针加起来遍历了一次数组
     */
    public int removeElement3(int[] nums, int val) {
        int i = 0; //指向数组中可以插入的地方
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        LeetCode27 leetCode27 = new LeetCode27();
        System.out.println(leetCode27.removeElement(new int[]{3, 2}, 3));
    }
}
