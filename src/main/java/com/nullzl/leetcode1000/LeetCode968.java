package com.nullzl.leetcode1000;

import com.nullzl.util.TreeNode;

public class LeetCode968 {

    private int[] traverse(TreeNode node){
        int max = 2000;
        if(null == node)
            return null;
        int[] left = traverse(node.left);
        int[] right = traverse(node.right);
        int[] ans = new int[3];
        if(null == left && null == right){
            return new int[]{max,1,0};
        }
        if(null == left || null == right){
            int[] temp = null == left ? right : left;
            return new int[]{temp[1],1 + Math.min(Math.min(temp[0],temp[1]),temp[2]),temp[0]};
        }
        ans[0] = Math.min(left[1] + right[1] , Math.min(left[0] + right[1],left[1] + right[0]));
        ans[2] = left[0] + right[0];
        ans[1] = Math.min(left[1] + right[2] , Math.min(left[0] + right[0],left[0] + right[2]));
        ans[1] = Math.min(ans[1],ans[0]);
        ans[1] = Math.min(ans[1],Math.min(left[2] + right[0] , Math.min(left[2] + right[1],left[2] + right[2]))) + 1;
        return ans;
    }

    public int minCameraCover(TreeNode root) {
        int[] ans = traverse(root);
        return Math.min(ans[0],ans[1]);
    }
}
