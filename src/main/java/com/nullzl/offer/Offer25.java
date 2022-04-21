package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer25 {




    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1)
            return l2;
        if(null == l2)
            return l1;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(null != l1 && null != l2){
            if(l1.val <= l2.val){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        if(null != l1)
            tail.next = l1;
        if(null != l2)
            tail.next = l2;
        return dummy.next;
    }
}
