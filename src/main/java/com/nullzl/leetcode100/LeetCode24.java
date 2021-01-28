package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.ListNode;

public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {

        if(null == head || null == head.next)
            return head;

        ListNode rs = new ListNode(0);
        ListNode curResultNode = rs;
        ListNode curNode = head;
        ListNode nextNode;

        while(null != curNode){
            nextNode = curNode.next;
            if(null != nextNode){
                ListNode temp = nextNode.next;
                curResultNode.next = nextNode;
                nextNode.next = curNode;
                curResultNode = curNode;
                curNode.next = null;
                curNode = temp;
            }else{
                curResultNode.next = curNode;
                curNode = null;
            }
        }
        return rs.next;


    }
}
