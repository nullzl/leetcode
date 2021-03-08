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

    public int minDepth(TreeNode root) {

        if(null == root)
            return 0 ;

        return depth(root,0);

    }
}
