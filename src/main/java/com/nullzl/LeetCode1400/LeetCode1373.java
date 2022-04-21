package com.nullzl.LeetCode1400;

import com.nullzl.util.TreeNode;

public class LeetCode1373 {

    int maxSum = 0;

    //[是否搜索子树，子树最大值，子树最小值，子树和]
    public int[] max(TreeNode root){
        if(null == root)
            return new int[]{1, Integer.MIN_VALUE,Integer.MAX_VALUE,0};
        int[] left = max(root.left);
        int[] right = max(root.right);
        if(0 == left[0] || 0 == right[0]){
            return new int[]{0,0,0,0};
        }
        if(root.val <= left[1] || root.val >= right[2])
            return new int[]{0,0,0,0};
        int sum = left[3] + right[3] + root.val;
        maxSum = Math.max(maxSum,sum);
        return new int[]{1,Math.max(root.val,right[1]),Math.min(root.val,left[2]), sum};
    }

    public int maxSumBST(TreeNode root) {
        max(root);
        return maxSum;
    }
}
