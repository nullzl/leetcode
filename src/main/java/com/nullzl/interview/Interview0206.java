package com.nullzl.interview;

import com.nullzl.util.ListNode;

public class Interview0206 {
    public boolean isPalindrome(ListNode head) {
        
        if(null == head)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(null != fast.next && null != fast.next.next){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode h2 = slow.next;
        slow.next = null;
        ListNode t2 = null;
        ListNode node = h2;
        while(null != node){
            ListNode t = node.next;
            node.next = t2;
            t2 = node;
            node = t;
        }
        node = t2;
        ListNode node2 = head;
        while(null != node){
            if(node.val != node2.val)
                break;
            node = node.next;
            node2 = node2.next;
        }
        node2 = t2;
        t2 = null;
        while(null != node2){
            ListNode t = node2.next;
            node2.next = t2;
            t2 = node2;
            node2 = t;
        }
        slow.next = t2;
        return node == null;

    }
}
