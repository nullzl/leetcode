package com.nullzl.leetcode100;

import com.nullzl.util.ListNode;

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(null == head || k <= 0)
            return head;
        int size = 0 ;
        ListNode cur = head;
        ListNode preNode = null;
        while(null != cur){
            size++;
            preNode = cur;
            cur = cur.next;
        }
        k = k % size ;
        if(0 == k)
            return head;
        cur = head;
        ListNode tail = preNode;
        preNode = null;
        for(int i = 0 ; i < size - k ; i++){
            preNode = cur;
            cur = cur.next;
        }
        preNode.next = null;
        tail.next = head;
        return cur;

    }
}
