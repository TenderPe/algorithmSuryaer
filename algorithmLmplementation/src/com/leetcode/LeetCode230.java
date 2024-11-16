package com.leetcode;

import java.util.Stack;

public class LeetCode230 {
    public int kthSmallest(TreeNode root, int k) {
        int n = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (stack != null || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                n++;
                if (n == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return 0;
    }
}
