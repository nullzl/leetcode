package com.nullzl.leetcode600;

import com.nullzl.util.TreeNode;

public class LeetCode530 {
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;
    private void traverse(TreeNode root){
        if(null == root)
            return ;
        traverse(root.left);
        if(null != prev){
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        traverse(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }
}
