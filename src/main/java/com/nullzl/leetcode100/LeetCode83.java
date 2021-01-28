package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.ListNode;

public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head)
            return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode lastNode = dummyNode;
        ListNode preNode = head;
        int preVal = head.val;
        ListNode curNode = head.next;
        while(null != curNode){
            if(curNode.val != preVal){
                preVal = curNode.val;
                if(lastNode.next != preNode){
                    lastNode.next = preNode;
                }
                lastNode = preNode;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        if(lastNode.next != preNode){
            lastNode.next = preNode;
        }
        return dummyNode.next;
    }
}
