package com.nullzl.leetcode900;

import com.nullzl.util.ListNode;

public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        if(null == head)
            return null;
        ListNode slow,fast;
        slow = head;
        fast = head;
        while(null != fast.next){
            fast = fast.next;
            fast = (null == fast.next ? fast : fast.next);
            slow = slow.next;
        }
        return slow;
    }
}
