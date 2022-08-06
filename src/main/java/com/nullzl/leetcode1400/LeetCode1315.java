package com.nullzl.leetcode1400;

import com.nullzl.util.TreeNode;

public class LeetCode1315 {

    int sum = 0;

    private void traverse(TreeNode root,TreeNode parent,TreeNode grandfather){
        if(null == root)
            return ;
        sum += grandfather == null ? 0 : root.val;

        traverse(root.left,(0 != (1 & root.val) ? null : root),parent);
        traverse(root.right,(0 != (1 & root.val) ? null : root),parent);
    }

    public int sumEvenGrandparent(TreeNode root) {
        traverse(root,null,null);
        return sum;
    }
}
