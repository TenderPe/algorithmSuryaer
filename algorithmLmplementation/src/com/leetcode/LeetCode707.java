package com.leetcode;

public class LeetCode707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);

        myLinkedList.addAtTail(3);  // 20 30 40 50 60 70
        myLinkedList.addAtIndex(1, 2);

        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);


    }
}

class MyLinkedList {
    public Node head = new Node(666, null);
    public int len = 0;

    public MyLinkedList() {
    }

    public static class Node {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public int get(int index) {
        int i = -1;
        Node cur = head;
        while (i != index && cur != null) {
            i++;
            cur = cur.next;
        }
        if (cur == null) {
            return -1;
        } else {
            return cur.val;
        }
    }

    public void addAtHead(int val) {
        head.next = new Node(val, head.next);
        len++;
    }

    public void addAtTail(int val) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val, null);
        len++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index > len) {
            return;
        }
        if (index == len) {
            addAtTail(val);
            return;
        }
        int i = -1;
        Node pre = head;
        while (i != index - 1 && pre != null) {
            i++;
            pre = pre.next;
        }
        pre.next = new Node(val, pre.next);
        len++;

    }

    public void deleteAtIndex(int index) {
        if (index >= len) {
            return;
        }
        int i = -1;
        Node cur = head;
        while (i != index - 1) {
            i++;
            cur = cur.next;
        }
        Node delete = cur.next;
        cur.next = delete.next;
        len--;
    }
}