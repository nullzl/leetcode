package com.nullzl.leetcode100;

import com.nullzl.util.ListNode;

public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = head;
        int i  = 1;
        while(i < n && null != tail.next){
            i++;
            tail = tail.next;
        }

        ListNode preNode = dummy;
        while(null != tail.next){
            tail = tail.next;
            preNode = preNode.next;
        }
        ListNode next = preNode.next;
        preNode.next = next.next;
        next.next = null;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {

        if(null == head || n <= 0)
            return head;

        ListNode preNode,curNode;
        int num = 0;
        curNode = head;
        preNode = null;
        while(null != curNode){
            num++;
            if(num == n + 1){
                preNode = head;
                break;
            }
            curNode = curNode.next;
        }
        if(null == curNode && n == num)
            return head.next;

        if(null == curNode)
            return head;

        while(null != curNode){
            curNode = curNode.next;
            if(null != curNode)
                preNode = preNode.next;
        }

        preNode.next = preNode.next.next;

        return head;


    }
}
