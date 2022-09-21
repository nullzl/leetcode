package com.nullzl.leetcode700;

import com.nullzl.util.TreeNode;

public class LeetCode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if(null == root)
            return null;
        if(root.val == val)
            return root;
        if(val < root.val)
            return searchBST(root.left,val);
        return searchBST(root.right,val);
    }
}
