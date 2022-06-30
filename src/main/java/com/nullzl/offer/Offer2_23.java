package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer2_23 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != node2){
            node1 = (null == node1 ? headB : node1.next);
            node2 = (null == node2 ? headA : node2.next);
        }
        return node1;
    }
}
