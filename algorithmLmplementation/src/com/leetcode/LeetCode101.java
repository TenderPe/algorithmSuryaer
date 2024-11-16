package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root.left == null) {
            if (root.right != null) {
                return false;
            }
        } else {
            if (root.right == null) {
                return false;
            }
            if (root.left.val != root.right.val) {
                return false;
            }
            queue1.add(root.left);
            queue2.add(root.right);
        }
        TreeNode node1 = null;
        TreeNode node2 = null;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            node1 = queue1.poll();
            node2 = queue2.poll();

            if (node1.left == null) {
                if (node2.right != null) {
                    return false;
                }
            } else {
                if (node2.right == null) {
                    return false;
                }
                if (node1.left.val != node2.right.val) {
                    return false;
                }
                queue1.add(node1.left);
                queue2.add(node2.right);
            }

            if (node1.right == null) {
                if (node2.left != null) {
                    return false;
                }
            } else {
                if (node2.left == null) {
                    return false;
                }
                if (node1.right.val != node2.left.val) {
                    return false;
                }
                queue1.add(node1.right);
                queue2.add(node2.left);
            }
        }
        if (!queue1.isEmpty()) {
            return false;
        }
        if (!queue2.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.of("[1,2,3,null,null,4,null,null,2,4,null,null,3,null,null]");
        boolean b = isSymmetric(root);
        PrintBinaryTree.printTree(root);

    }
}
