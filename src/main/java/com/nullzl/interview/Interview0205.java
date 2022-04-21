package com.nullzl.interview;

import com.nullzl.util.ListNode;

public class Interview0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1)
            return l2;
        if(null == l2)
            return l1;

        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(null != l1 || null != l2){
            sum += ((null == l1 ? 0 : l1.val)
                    + (null == l2 ? 0 : l2.val));
            l1 = null == l1 ? null : l1.next;
            l2 = null == l2 ? null : l2.next;
            ListNode node = new ListNode(sum % 10);
            sum /= 10;
            tail.next = node;
            tail = node;
        }
        if(0 != sum){
            ListNode node = new ListNode(sum );
            tail.next = node;
        }
        return dummy.next;
    }
}
