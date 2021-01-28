package main.java.com.nullzl.leetcode200;


import java.util.HashMap;

public class LeetCode138 {
    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if(null == head)
            return head;

        Node cur = head;

        while(null != cur){
            Node next = cur.next;
            Node copy = new Node();
            copy.val = cur.val;
            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        Node copyHead = head.next;
        cur = head;
        while(null != cur){
            Node newNode = cur.next;
            Node random = cur.random;
            newNode.random = (null == random ? null : random.next);
            cur = newNode.next;
        }

        cur = head;
        while(null != cur){
            Node newNode = cur.next;
            Node next = newNode.next;
            Node newNext = (null == next ? null : next.next);
            cur.next = next;
            newNode.next = newNext;
            cur = next;
        }

        return copyHead;

    }
}
