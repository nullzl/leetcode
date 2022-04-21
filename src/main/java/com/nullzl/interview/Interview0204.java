package com.nullzl.interview;

import com.nullzl.util.ListNode;

public class Interview0204 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = head;
        ListNode previouse = dummy2;
        ListNode node = head;
        while(null != node){
            if(node.val < x){
                previouse.next = node.next;
                node.next = null;
                tail.next = node;
                tail = node;
                node = previouse.next;
            }else{
                previouse = node;
                node = node.next;
            }
        }
        tail.next = dummy2.next;
        return dummy.next;
    }

}
