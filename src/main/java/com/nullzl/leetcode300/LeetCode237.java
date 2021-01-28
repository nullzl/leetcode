package main.java.com.nullzl.leetcode300;

import main.java.com.nullzl.util.ListNode;

public class LeetCode237 {
    public void deleteNode(ListNode node) {

        if(null == node || null == node.next)
            return ;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;

    }
}
