package com.nullzl.leetcode200;

import com.nullzl.util.ListNode;
import com.nullzl.util.TreeNode;

public class LeetCode109 {

    public TreeNode sortedListToBST(ListNode head) {

        if(null == head)
            return null;

        ListNode preNode = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(null != fast){
            fast = fast.next;
            if(null != fast)
                fast = fast.next;
            preNode = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(null != preNode)
            preNode.next = null;
        root.left = slow == head ? null : sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;

    }
}
