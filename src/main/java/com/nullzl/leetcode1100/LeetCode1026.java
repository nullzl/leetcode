package com.nullzl.leetcode1100;

import com.nullzl.util.TreeNode;

public class LeetCode1026 {

    int max = 0;

    private int[] traverse(TreeNode root,int p){
        if(null == root)
            return new int[]{p,p};
        int[] left = traverse(root.left,root.val);
        int[] right = traverse(root.right,root.val);
        left[0] = Math.min(left[0],right[0]);
        left[1] = Math.max(left[1],right[1]);
        max = Math.max(max,Math.abs(root.val - left[0]));
        max = Math.max(max,Math.abs(root.val - left[1]));
        left[0] = Math.min(left[0],root.val);
        left[1] = Math.max(left[1],root.val);
        return left;
    }

    public int maxAncestorDiff(TreeNode root) {
        traverse(root,root.val);
        return max;
    }
}
