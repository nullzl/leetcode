package com.nullzl.leetcode600;

import com.nullzl.util.TreeNode;

public class LeetCode513 {

    int depth = Integer.MIN_VALUE;
    int val = -1;

    private void dfs(TreeNode root,int d){
        if(null == root)
            return ;
        dfs(root.left,d + 1);
        dfs(root.right,d + 1);
        if(d > depth) {
            depth = d;
            val = root.val;
        }

    }

    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return val;
    }


}
