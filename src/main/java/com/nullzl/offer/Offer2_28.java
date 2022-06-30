package com.nullzl.offer;

public class Offer2_28 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    private Node[] flat(Node head){
        if(null == head)
            return new Node[]{null,null};
        Node tail = head;
        Node[] child = flat(head.child);
        Node[] next = flat(head.next);
        head.child = null;
        if(null != child[0]){
            tail.next = child[0];
            child[0].prev = tail;
            tail = child[1];
        }
        if(null != next[0]){
            tail.next = next[0];
            next[0].prev = tail;
            tail = next[1];
        }
        return new Node[]{head,tail};
    }

    public Node flatten(Node head) {
        return flat(head)[0];
    }
}
