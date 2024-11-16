package com.leetcode;

public class LeetCode112 {
    static boolean f = false;
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return f;
        }
        process(root, targetSum, 0);
        return f;
    }

    public static void process(TreeNode root, int targetSum, int s) {
        if(s == targetSum) {
            f = true;
            return;
        }
        if(root == null) {
            return;
        }
        process(root.left, targetSum, s+root.val);

        process(root.right, targetSum, s+root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(hasPathSum(node1, 5));
    }
}
