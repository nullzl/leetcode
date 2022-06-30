package com.nullzl.offer;

public class Offer2_29 {

    class Node {
        public int val;
        public Node next;
    };

    public Node insert(Node head, int insertVal) {
        Node node = new Node();
        node.val = insertVal;
        if(null == head){
            node.next = node;
            return node;
        }

        if(head == head.next){
            head.next = node;
            node.next = head;
            return head;
        }

        Node prev = head;
        Node cur = head.next;
        do{
            if(cur.val < prev.val)
                break;
            prev = cur;
            cur = cur.next;
        }while(cur != head.next);
        Node temp = cur;
        do{
            if(temp.val == node.val || (node.val > temp.val && node.val < temp.next.val)){
                Node t = temp.next;
                temp.next = node;
                node.next = t;
                return head;
            }
            temp = temp.next;
        }while(temp != cur);
        prev.next = node;
        node.next = cur;
        return head;
    }
}
