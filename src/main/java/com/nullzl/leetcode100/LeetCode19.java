package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.ListNode;

public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

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
