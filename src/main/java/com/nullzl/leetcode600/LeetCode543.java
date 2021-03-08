package com.nullzl.leetcode600;

import com.nullzl.util.TreeNode;

public class LeetCode543 {

    int max = 0;

    public int height(TreeNode root) {
        if(null == root)
            return 0;

        int leftHeight = (null == root.left ? 0 : height(root.left) + 1);
        int rightHeight = (null == root.right ? 0 : height(root.right) + 1);
        max = Math.max(max,leftHeight + rightHeight);
        return Math.max(leftHeight,rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(null == root)
            return 0;
        max = Math.max( (null == root.left ? 0 : height(root.left) + 1)
                + (null == root.right ? 0 : height(root.right) + 1),max);
        return max;

    }
}
