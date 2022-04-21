package com.nullzl.LeetCode1400;

import com.nullzl.util.TreeNode;

public class LeetCode1372 {
    private int max;

    private int[] traverse(TreeNode root){
        if(null == root)
            return new int[]{0,0};
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int[] count = new int[2];
        count[0] = left[1] + 1;
        count[1] = right[0] + 1;
        max = Math.max(max,count[0]);
        max = Math.max(max,count[1]);
        return count;
    }

    public int longestZigZag(TreeNode root) {
        traverse(root);
        return max - 1;
    }
}
