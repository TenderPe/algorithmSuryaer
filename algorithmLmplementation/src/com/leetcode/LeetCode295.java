package com.leetcode;

import java.util.PriorityQueue;

public class LeetCode295 {
    static class MedianFinder {
        public PriorityQueue<Integer> smallHeap;
        public PriorityQueue<Integer> bigHeap;

        public MedianFinder() {
            smallHeap = new PriorityQueue<>();
            bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        }

        public void addNum(int num) {
            if (bigHeap.isEmpty()) {
                bigHeap.add(num);
            } else {
                if (bigHeap.peek() < num) {
                    smallHeap.add(num);
                } else {
                    bigHeap.add(num);
                }
            }
            if (Math.abs(smallHeap.size() - bigHeap.size()) >= 2) {
                if (bigHeap.size() > smallHeap.size()) {
                    smallHeap.add(bigHeap.poll());
                } else {
                    bigHeap.add(smallHeap.poll());
                }
            }
        }

        public double findMedian() {
            int ssize = smallHeap.size();
            int bsize = bigHeap.size();
            if (((ssize + bsize) & 1) == 0) {
                return (smallHeap.peek() + bigHeap.peek()) / 2.0;
            } else {
                return bsize > ssize ? bigHeap.peek() : smallHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
