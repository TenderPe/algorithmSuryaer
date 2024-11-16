package com.leetcode;

public class LeetCode1423 {
    public static int maxScore(int[] cardPoints, int k) {
        return f(cardPoints, 0, cardPoints.length - 1, k);
    }

    public static int f(int[] cardPoints, int start, int end, int k) {
        if (k == 0) {
            return 0;
        }
        if (start == end) {
            return cardPoints[start];
        }
        return Math.max(cardPoints[start] + f(cardPoints, start + 1, end, k - 1),
                cardPoints[end] + f(cardPoints, start, end - 1, k - 1));
    }


    public static void main(String[] args) {
        int[] cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int maxScore = maxScore(cardPoints, k);
        System.out.println(maxScore);
    }
}
