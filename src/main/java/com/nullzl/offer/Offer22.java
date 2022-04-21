package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer22 {


    public ListNode getKthFromEnd(ListNode head, int k) {
        if(null == head || k <= 0)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        int i;
        for(i = 1 ;  i < k && null != fast.next ; i++)
            fast = fast.next;
        if(i < k)
            return null;
        while(null != fast.next){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
