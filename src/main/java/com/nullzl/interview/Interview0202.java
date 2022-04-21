package com.nullzl.interview;

import com.nullzl.util.ListNode;

public class Interview0202 {

    public int kthToLast(ListNode head, int k) {

        ListNode first = head;
        ListNode sec = head;
        int i = 1;
        while(null != sec && i <= k){
            sec = sec.next;
            i++;
        }

        while(null != sec.next){
            sec = sec.next;
            first = first.next;
        }
        return first.val;
    }
}
