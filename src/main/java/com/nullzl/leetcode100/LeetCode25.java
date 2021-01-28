package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.ListNode;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
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
