package com.nullzl.leetcode100;

import com.nullzl.util.ListNode;

public class LeetCode25 {

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        head = null;
        while(null != cur){
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        dummy.next = null;
        ListNode cur = head;
        while(null != cur){
            int i  = 1;
            ListNode node = cur;
            while(i < k && null != node.next){
                i++;
                node = node.next;
            }
            ListNode next = node.next;
            node.next = null;

            if(i == k) {
                node = cur;
                cur = reverse(cur);
            }

            tail.next = cur;
            tail = node;
            cur = next;
        }
        return dummy.next;
    }
    public ListNode reverseKGroup1(ListNode head, int k) {
        if(null == head || 1 == k)
            return head;

        ListNode rs = new ListNode(0);
        ListNode curResultNode = rs;
        ListNode curNode = head;
        ListNode preNode = null;
        ListNode curHead = null;
        int n ;
        while(null != curNode){
            preNode = curNode;
            curNode = curNode.next;
            preNode.next = null;
            curHead = preNode;
            n = 1;
            while(null != curNode && n < k){
                ListNode temp = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = temp;
                n++;
            }
            if(n != k){
                curNode = preNode.next;
                preNode.next = null;
                while(null != curNode){
                    ListNode temp = curNode.next;
                    curNode.next = preNode;
                    preNode = curNode;
                    curNode = temp;
                }
                curNode = null;
            }
            curResultNode.next = preNode;
            curResultNode = curHead;
        }
        return rs.next;
    }
}
