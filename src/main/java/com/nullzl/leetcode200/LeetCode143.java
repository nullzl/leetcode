package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.ListNode;

public class LeetCode143 {

    public void reorderList(ListNode head) {

        if(null == head)
            return ;

        ListNode slow = head;
        ListNode fast = head.next;
        while(null != fast && null != fast.next){
            slow = slow.next;
            if(null != fast.next)
                fast = fast.next;
            if(null != fast.next)
                fast = fast.next;
        }

        if(null == fast)
            return ;

        ListNode cur = slow.next;
        slow.next = null;
        ListNode preNode = null;
        while(null != cur){
            ListNode temp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = temp;
        }

        cur = preNode;
        slow = head;
        while(null != cur){
            ListNode  temp1 = slow.next;
            ListNode temp2 = cur.next;
            slow.next = cur;
            cur.next = temp1;
            slow = temp1;
            cur = temp2;
        }


    }
}
