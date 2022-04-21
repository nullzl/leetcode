package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer24 {

    public ListNode reverseList(ListNode head) {

        ListNode node = head;
        ListNode previous = null;

        while(null != node){
            ListNode tmp = node.next;
            node.next = previous;
            previous = node;
            node = tmp;
        }
        return previous;
    }
}
