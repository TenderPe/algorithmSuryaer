package com.leetcode;

import java.util.ArrayList;

public class LeetCode86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int l = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val < x) {
                list.add(++l, list.get(i));
            }
        }
        int i = 0;
        for (; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(i).next = null;
        return list.get(0);
    }
}
