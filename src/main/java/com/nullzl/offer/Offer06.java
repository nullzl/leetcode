package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer06 {

    public int[] reversePrint(ListNode head) {
        ListNode tail = null;
        int size = 0;
        while(null != head){
            size++;
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }
        int[] rs = new int[size];
        int i = 0;
        head = null;
        while(null != tail){
            rs[i++] = tail.val;
            ListNode tmp = tail.next;
            tail.next = head;
            head = tail;
            tail = tmp;
        }
        return rs;
    }
}
