package com.nullzl.leetcode700;

import com.nullzl.util.TreeNode;

public class LeetCode687 {

    private int longestPath = 0;

    public int longestPath(TreeNode root) {

        if(null == root)
            return 0;

        int left = longestPath(root.left);
        int right = longestPath(root.right);

        left = (null != root.left && root.left.val == root.val) ? 1 + left : 0;
        right = (null != root.right && root.right.val == root.val) ? 1 + right : 0;
        int path = left + right;
        if(path > longestPath)
            longestPath = path;
        return Math.max(left,right);
    }

    public int longestUnivaluePath(TreeNode root) {
        longestPath(root);
        return longestPath;
    }
}
