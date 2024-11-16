package com.leetcode;

import java.util.*;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curLevelEndNode = root;
        TreeNode nextLevelEndNode = null;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
                nextLevelEndNode = root.left;
            }
            if (root.right != null) {
                queue.add(root.right);
                nextLevelEndNode = root.right;
            }
            if (root == curLevelEndNode) {
                result.add(list);
                curLevelEndNode = nextLevelEndNode;
                nextLevelEndNode = null;
                list = new ArrayList<>();
            }
        }
        return result;
    }
}
