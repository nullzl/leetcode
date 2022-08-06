package com.nullzl.leetcode800;

import com.nullzl.util.TreeNode;

public class LeetCode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        dummy.left = root;
        TreeNode prev = dummy;
        TreeNode cur = root;
        while(null != cur){
            prev = cur;
            if(val < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if(val < prev.val )
            prev.left = new TreeNode(val);
        else
            prev.right = new TreeNode(val);
        return dummy.left;
    }
}
