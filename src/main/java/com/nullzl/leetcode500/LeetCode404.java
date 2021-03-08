package com.nullzl.leetcode500;

import com.nullzl.util.TreeNode;

public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if(null == root)
            return 0;
        return sumOfLeftLeaves(root.right) +
                (null != root.left ? (null == root.left.left && null == root.left.right ? root.left.val : sumOfLeftLeaves(root.left)) : 0);

    }
}
