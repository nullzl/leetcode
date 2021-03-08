package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

public class LeetCode104 {

    public int maxDepth(TreeNode root) {

        if(null == root)
            return 0 ;

        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

    }
}
