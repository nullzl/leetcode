package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

public class LeetCode111 {

    private int depth(TreeNode root,int depth){
        if(null == root)
            return Integer.MAX_VALUE;
        if(null == root.left && null == root.right)
            return depth + 1;
        return Math.min(depth(root.left,depth + 1),depth(root.right,depth + 1));
    }

    public int minDepth1(TreeNode root) {

        if(null == root)
            return 0 ;

        return depth(root,0);

    }

    public int minDepth(TreeNode root) {
        if(null == root)
            return 0;
        if(null == root.left && null == root.right)
            return 1;
        if(null == root.left)
            return minDepth(root.right) + 1;
        if(null == root.right)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
