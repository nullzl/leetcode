package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer2_21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i = 1 ; i <= n ; i++){
            fast = fast.next;
        }
        while(null != fast.next){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
