package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode98 {
    public static int min = Integer.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isValidBSTLeft = isValidBST(root.left);
        if (!isValidBSTLeft) {
            return false;
        }
        if (root.val <= min) {
            return false;
        } else {
            min = root.val;
        }
        return isValidBST(root.right);
    }

    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        long min = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= min) {
                    return false;
                } else {
                    min = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean f = isValidBST2(root);
        System.out.println(f);


    }
}
