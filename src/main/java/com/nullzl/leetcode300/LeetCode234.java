package com.nullzl.leetcode300;

import com.nullzl.util.ListNode;

public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if(null == head || null == head.next)
            return true;

        ListNode midNode = head;
        ListNode nextNode = head.next;
        ListNode tailNode = head.next;
        ListNode temp,preNode ;
        int count = 2;
        midNode.next = null;

        while(null != tailNode.next){
            tailNode = tailNode.next;
            count++;
            if(null != tailNode.next){
                tailNode = tailNode.next;
                count++;
            }
            temp = nextNode.next;
            nextNode.next = midNode;
            midNode = nextNode;
            nextNode = temp;
        }

        if(count % 2 == 1){
            temp = midNode.next;
            midNode.next = nextNode;
            preNode = midNode;
            midNode = temp;
        }else{
            preNode = nextNode;
        }
        while(null != midNode && null != nextNode){
            if(midNode.val != nextNode.val)
                return false;
            temp =midNode.next;
            midNode.next = preNode;
            preNode = midNode;
            midNode = temp;
            nextNode = nextNode.next;
        }
        return true;
    }
}
