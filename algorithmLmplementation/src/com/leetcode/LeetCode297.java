package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.leetcode.PrintBinaryTree.printTree;

public class LeetCode297 {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String tree = root.val + "_";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return tree + left + right;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] str = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : str) {
            queue.add(s);
        }
        return build(queue);
    }

    public static TreeNode build(Queue<String> queue) {
        if (!queue.isEmpty()) {
            String x = queue.poll();
            if (x.equals("#")) {
                return null;
            }
            TreeNode head = new TreeNode(Integer.valueOf(x));
            head.left = build(queue);
            head.right = build(queue);
            return head;
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "[1,2,3,null,null,4,5]";
        TreeNode root = TreeNode.of(str);
        printTree(root);
        System.out.println(serialize(root));
        TreeNode head = deserialize(serialize(root));
        printTree(head);
    }
}
