package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode662 {
    public static int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        root = new TreeNode(1, root.left, root.right);
        queue.add(root);
        int result = 0;
        int startIndex = -1;
        int endIndex = -1;
        TreeNode curLevelEndNode = root;
        TreeNode nextLevelEndNode = null;
        while (!queue.isEmpty()) {
            root = queue.poll();
            startIndex = startIndex == -1 ? root.val : startIndex;
            endIndex = root.val;
            if (root.left != null) {
                TreeNode newLeft = new TreeNode(2 * root.val, root.left.left, root.left.right);
                queue.add(newLeft);
                nextLevelEndNode = newLeft;
            }
            if (root.right != null) {
                TreeNode newRight = new TreeNode(2 * root.val + 1, root.right.left, root.right.right);
                queue.add(newRight);
                nextLevelEndNode = newRight;
            }
            if (root == curLevelEndNode) {
                result = Math.max(result, endIndex - startIndex + 1);
                curLevelEndNode = nextLevelEndNode;
                nextLevelEndNode = null;
                startIndex = -1;
                endIndex = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        int h = widthOfBinaryTree(root);
        System.out.println(h);


    }
}
