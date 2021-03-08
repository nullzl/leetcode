package com.nullzl.leetcode300;

import com.nullzl.util.ListNode;

public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {

        if(null == head)
            return head;

        ListNode oddTail = head;
        ListNode cur = head.next;
        ListNode oddNode,tempNode;
        while(null != cur){
            oddNode = cur.next;
            if(null == oddNode) {
                break;
            }
            cur.next = oddNode.next;
            tempNode = oddTail.next;
            oddTail.next = oddNode;
            oddNode.next = tempNode;
            oddTail = oddNode;
            cur = cur.next;
        }
        return head;
    }
}
