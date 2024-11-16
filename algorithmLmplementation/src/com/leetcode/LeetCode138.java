package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node res = new Node(0);
        Node cur = res;
        Node old = head;
        while(head != null) {
            cur.next = new Node(head.val);
            cur = cur.next;
            map.put(cur, head);
            head = head.next;
        }
        cur = res.next;
        while(old != null) {
            cur.random = map.get(old.random);
            old = old.next;
            cur = cur.next;
        }
        return res.next;
    }

    public static void main(String[] args) {

    }
}
