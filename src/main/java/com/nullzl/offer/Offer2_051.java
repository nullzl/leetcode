package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer2_051 {

    int maxSum = Integer.MIN_VALUE;

    private int max(TreeNode root){
        if(null == root)
            return 0;
        int left = max(root.left);
        int right = max(root.right);
        int max = Math.max(left,right) + root.val;
        max = Math.max(max,root.val);
        maxSum = Math.max(maxSum,max);
        maxSum = Math.max(maxSum,left + right + root.val);
        return max;
    }

    public int maxPathSum(TreeNode root) {
        max(root);
        return maxSum;
    }
}
