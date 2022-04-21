package com.nullzl.interview;

import com.nullzl.util.ListNode;

public class Interview0201 {

    public ListNode removeDuplicateNodes(ListNode head) {

        boolean[] map = new boolean[20001];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previous = dummy;
        ListNode node = head;
        while(null != node){
            if(map[node.val]){
                previous.next = node.next;
                node.next = null;
                node = previous.next;
            }else{
                map[node.val] = true;
                previous = node;
                node = node.next;
            }
        }
        return dummy.next;
    }
}
