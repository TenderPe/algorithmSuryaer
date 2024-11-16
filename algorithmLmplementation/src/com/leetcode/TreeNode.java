package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

import static com.leetcode.PrintBinaryTree.printTree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //传入先序遍历字符串 带null  字符串反序列化为二叉树
    public static TreeNode of(String str1) {
        String str2 = str1.substring(1, str1.length() - 1);
        String[] str = str2.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : str) {
            System.out.print(s + " ");
            queue.add(s);
        }
        TreeNode root = process(queue);
        return root;
    }

    private static TreeNode process(Queue<String> queue) {
        String x = queue.poll();
        if (x == null) {
            return null;
        }
        if (x.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(x));
        root.left = process(queue);
        root.right = process(queue);
        return root;
    }
}
