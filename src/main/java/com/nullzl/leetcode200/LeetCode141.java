package com.nullzl.leetcode200;

import com.nullzl.util.ListNode;

public class LeetCode141 {

    public boolean hasCycle(ListNode head) {

        if(null == head)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while(null != fast){
            slow = slow.next;
            fast = (null != fast.next ? fast.next.next : null);
            if(slow == fast)
                break;
        }
        if(null == fast)
            return false;
        return true;


    }
}
