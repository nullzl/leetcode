package com.nullzl.leetcode300;

import com.nullzl.util.ListNode;

public class LeetCode206 {

    public ListNode reverseList(ListNode head) {

        if(null == head)
            return head;

        ListNode preNode = head;
        ListNode cur = head.next;
        preNode.next = null;
        ListNode temp;
        while(null != cur){
            temp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = temp;
        }
        return preNode;
    }
}
