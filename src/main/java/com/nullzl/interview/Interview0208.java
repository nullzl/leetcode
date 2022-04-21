package com.nullzl.interview;

import com.nullzl.util.ListNode;

public class Interview0208 {

    public ListNode detectCycle(ListNode head) {
        if(null == head)
            return null;
        ListNode first = head.next;
        ListNode sec = null == head.next ? null : head.next.next;
        while(null != sec && first != sec){
            first = first.next;
            sec = null == sec.next ? null : sec.next.next;
        }

        if(null == sec)
            return null;
        first = head;
        while(first != sec){
            first = first.next;
            sec = sec.next;
        }
        return first;
    }
}
