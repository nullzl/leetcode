package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer2_24 {

    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode cur = head;
        while(null != cur){
            ListNode temp = cur.next;
            cur.next = node;
            node = cur;
            cur = temp;
        }
        return node;
    }
}
