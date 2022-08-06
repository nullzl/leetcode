package com.nullzl.leetcode1200;

import com.nullzl.util.ListNode;

import java.util.HashMap;

public class LeetCode1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer,ListNode> map = new HashMap<>();
        map.put(0,dummy);
        int sum = 0;
        ListNode node = head;
        while(null != node){
            sum += node.val;
            ListNode tail = map.getOrDefault(sum,null);
            if(null == tail) {
                map.put(sum,node);
                node = node.next;
                continue;
            }
            ListNode temp = tail.next;
            int s = sum;
            while(temp != node){
                s += temp.val;
                map.remove(s);
                temp = temp.next;
            }
            node = node.next;
            tail.next = node;
        }
        return dummy.next;
    }
}
