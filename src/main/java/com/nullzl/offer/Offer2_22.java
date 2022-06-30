package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer2_22 {

    public ListNode detectCycle(ListNode head) {
        if(null == head || null == head.next)
            return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(null != fast && null != fast.next && fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(null == fast || null == fast.next)
            return null;

        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
