package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        if (nums != null || !(nums.length < 2)) {
            quickSort(nums, 0, nums.length - 1);
        }
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            //随机选择一个元素与最后一位元素互换位置
            swap(nums, l + (int) (Math.random() * (r - l + 1)), r);
            int p[] = partiion(nums, l, r, nums[r]);
            quickSort(nums, l, p[0]);
            quickSort(nums, p[1], r);
        }
    }

    private int[] partiion(int[] nums, int l, int r, int num) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (nums[l] < nums[r]) {
                swap(nums, ++less, l++);
            } else if (nums[l] > nums[r]) {
                swap(nums, --more, l);
            } else {
                l++;
            }
        }
        swap(nums, more, r);
        return new int[]{less, more + 1};

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //堆排序写法
    public int[] sortArray2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        //0号元素是大根堆的头结点 最大 换到数组末尾
        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
        return nums;
    }

    //某个数在index位置上 是否可以往下移动
    private void heapify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;   //是不是有左孩子
        while (left < heapSize) {
            //两个孩子节点谁大把坐标给largest
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            //父亲节点和最大的孩子节点比 谁大把索引给largest
            largest = nums[index] > nums[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            swap(nums, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    //某个数现在在index位置上 继续往上移动
    private void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //基数排序
    public int[] sortArray3(int[] nums) {
        if (nums == null && nums.length < 2) {
            return nums;
        }
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }
        int bits = getBits(maxNum);
        radixSort(nums, 0, nums.length - 1, bits);

        return nums;
    }

    private void radixSort(int[] nums, int l, int r, int bits) {
        final int radix = 10;
        int[] help = new int[r - l + 1];
        for (int i = 1; i <= bits; i++) {
            int[] bucket = new int[radix];
            for (int j = l; j <= r; j++) {
                int bitNum = getBitNum(nums[j], i);
                bucket[bitNum]++;
            }
            for (int j = 1; j < radix; j++) {
                bucket[j] += bucket[j - 1];
            }
            for (int j = r; j >= l; j--) {
                int bitNum = getBitNum(nums[j], i);
                help[bucket[bitNum] - 1] = nums[j];
                bucket[bitNum]--;
                ;
            }
            for (int j = l, k = 0; j <= r; j++, k++) {
                nums[j] = help[k];
            }
        }
    }

    //获取数字num指定位数的数值 123 如果i为1获取个位数值 为3
    private int getBitNum(int num, int i) {

        return (num / (int) (Math.pow(10, i - 1))) % 10;
    }

    private int getBits(int num) {
        int bits = 0;
        while (num != 0) {
            bits++;
            num /= 10;
        }
        return bits;
    }

    public static void main(String[] args) {
        int maxSize = 5000000;
        int maxValue = 10000000;
        int[] nums = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (maxValue * Math.random());
        }

        LeetCode912 sort = new LeetCode912();
        long startTime = 0;
        long endTime = 0;
        startTime = System.currentTimeMillis();
        sort.sortArray3(nums);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        sort.sortArray2(nums);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        sort.sortArray(nums);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }


}
