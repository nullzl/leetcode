package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while(null != node.next && node.next.val != val)
            node = node.next;
        if(null != node.next)
            node.next = node.next.next;
        return dummy.next;

    }
}
