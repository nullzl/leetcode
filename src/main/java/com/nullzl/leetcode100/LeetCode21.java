package com.nullzl.leetcode100;

import com.nullzl.util.ListNode;

public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null,preNode1 = null,preNode2 = null;
        ListNode curNode1 ,curNode2 ;

        if(null == l1)
            return l2;
        if(null == l2)
            return l1;
        if(l1.val < l2.val){
            head = l1;
            curNode1 = l1;
            curNode2 = l2;
        }else{
            head = l2;
            curNode1 = l2;
            curNode2 = l1;
        }

        while(null != curNode2){
            if(null == curNode1){
                preNode1.next =  curNode2;
                return head;
            }
            if(curNode1.val > curNode2.val){
                preNode1.next = curNode2;
                preNode2 = curNode2;
                curNode2 = curNode2.next;
                while(null != curNode2 && curNode2.val <= curNode1.val){
                    preNode2 = curNode2;
                    curNode2 = curNode2.next;
                }
                if(null == curNode2){
                    preNode2.next = curNode1;
                }else{
                    preNode1 = preNode2;
                    preNode2.next = curNode1;
                }
            }else{
                preNode1 = curNode1;
                curNode1 = curNode1.next;
            }
        }
        return head;
    }
}
