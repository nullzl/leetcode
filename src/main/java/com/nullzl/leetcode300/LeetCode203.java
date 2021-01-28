package main.java.com.nullzl.leetcode300;

import main.java.com.nullzl.util.ListNode;

public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        if(null == head)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode cur = head;
        while(null != cur){
            if(val == cur.val){
                preNode.next = cur.next;
                cur = cur.next;
            }else{
                preNode = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
