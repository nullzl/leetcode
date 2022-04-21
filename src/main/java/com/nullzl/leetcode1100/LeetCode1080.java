package com.nullzl.leetcode1100;

import com.nullzl.util.TreeNode;

public class LeetCode1080 {

    private boolean traverse(TreeNode root,int prefix,int limit){
        if(null == root)
            return false;
        prefix += root.val;
        if(null == root.left && null == root.right)
            return prefix >= limit;
        boolean left = traverse(root.left,prefix,limit);
        boolean right = traverse(root.right,prefix,limit);
        if(!left && !right)
            return false;
        if(!left)
            root.left = null;
        if(!right)
            root.right = null;
        return true;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {

        boolean rs = traverse(root,0,limit);
        return rs ? root : null;
    }
}
