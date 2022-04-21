package com.nullzl.leetcode1100;

import com.nullzl.util.TreeNode;

public class LeetCode1038 {

    int sum = 0;

    private void traverse(TreeNode root){
        if(null == root)
            return ;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
}
