package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        if(root != null) {
            queue.add(root);
        }
        int f = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            if(f == 1) {
                for(int j = size-1; j >= 0; j--) {
                    TreeNode node = queue.get(j);
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                }
            } else {
                for(int k = size-1; k >= 0; k--) {
                    TreeNode node = queue.get(k);
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            for(int i =0; i < size; i++) {
                TreeNode node = queue.remove(0);
                list.add(node.val);
            }
            f ^= 1;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        List<List<Integer>> lists = zigzagLevelOrder(node1);

        System.out.println();

    }
}
