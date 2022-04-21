package com.nullzl.interview;

import com.nullzl.util.ListNode;

public class Interview0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA,p2 = headB;
        while(p1 != p2){
            p1 = null == p1 ? headB : p1.next;
            p2 = null == p2 ? headA : p2.next;
        }
        return p1;
    }
}
