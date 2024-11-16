package com.leetcode;

public class LeetCode100 {
    static boolean f = true;
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        process(p, q);
        return f;
    }

    public static void process(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return;
        }
        if(p == null || q == null) {
            f = false;
            return;
        }
        if(p.val != q.val) {
            f = false;
            return;
        }
        process(p.left, q.left);
        process(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        TreeNode t3 = new TreeNode(1);

        TreeNode t5 = new TreeNode(2);
        t3.right = t5;
        isSameTree(t1, t3);
    }
}
