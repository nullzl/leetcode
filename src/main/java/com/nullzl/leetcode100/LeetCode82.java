package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.ListNode;

public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head)
            return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        int preVal = head.val;
        ListNode preNode = head;
        ListNode lastNode = dummyNode;
        ListNode curNode = head.next;

        while(null != curNode){
            if(curNode.val != preVal){
                preVal = curNode.val;
                if(lastNode.next == preNode){
                    lastNode = preNode;
                }else{
                    lastNode.next = curNode;
                }
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        if(lastNode.next != preNode){
            lastNode.next = null;
        }
        return dummyNode.next;
    }
}
