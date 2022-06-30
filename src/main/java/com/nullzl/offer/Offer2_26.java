package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer2_26 {

    public void reorderList(ListNode head) {

        ListNode node = head;
        ListNode mid = head;
        while(null != node.next && null != node.next.next){
            mid = mid.next;
            node = node.next.next;
        }

        node = mid.next;
        mid.next = null;
        mid = null;
        while(null != node){
            ListNode temp = node.next;
            node.next = mid;
            mid = node;
            node = temp;
        }
        node = head;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(null != mid && null != node){
            tail.next = node;
            node = node.next;
            tail.next.next = mid;
            tail = mid;
            mid = mid.next;
        }
        if(null != node)
            tail.next = node;
        dummy.next = null;

    }
}
