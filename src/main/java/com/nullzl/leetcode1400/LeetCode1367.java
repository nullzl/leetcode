package com.nullzl.leetcode1400;

import com.nullzl.util.ListNode;
import com.nullzl.util.TreeNode;

public class LeetCode1367 {

    private boolean isSame(ListNode head,TreeNode root){
        if(null == head)
            return true;
        if(null == root)
            return false;
        return head.val == root.val && (isSame(head.next,root.left) || isSame(head.next,root.right));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(null != head && null == root)
            return false;

        return isSame(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);

    }
}
