package com.nullzl.interview;

import com.nullzl.util.ListNode;

public class Interview0203 {

    public void deleteNode(ListNode node) {
        if(null == node.next)
            return ;
        node.val = node.next.val;
        ListNode next = node.next;
        node.next = next.next;
        next.next = null;
    }
}
