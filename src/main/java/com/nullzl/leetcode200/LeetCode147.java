package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.ListNode;

public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {

        if(null == head)
            return head;

        ListNode cur = head.next;
        ListNode dummy = new ListNode(0x80000000);
        dummy.next = null;
        head.next = dummy;
        ListNode head1 = head;
        ListNode preNode = null;

        while(null != cur){
            ListNode temp = head1;
            preNode = null;
            while(cur.val < temp.val){
                preNode = temp;
                temp = temp.next;
            }
            temp = cur.next;
            if(null == preNode){
                cur.next = head1;
                head1 = cur;
            }else{
                cur.next = preNode.next;
                preNode.next = cur;
            }
            cur = temp;
        }
        cur = head1;
        preNode = null;
        while(null != cur){
            ListNode temp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = temp;
        }
        return dummy.next;
    }
}
