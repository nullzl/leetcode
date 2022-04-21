package com.nullzl.leetcode1000;

import com.nullzl.util.TreeNode;

public class LeetCode958 {

    int maxLevel = 0;
    boolean exist = false;
    private boolean dfs(TreeNode root,int level){
        if(null == root){
            if(level < maxLevel - 1)
                return false;
            if(level == maxLevel - 1 && exist)
                return true;
            if(level == maxLevel -1 && !exist){
                exist = true;
                return true;
            }
            if(level >= maxLevel)
                return true;
        }
        //root != null
        if(level >= maxLevel)
            return false;
        if(level == maxLevel - 1 && exist)
            return false;

        return  dfs(root.left,level + 1) && dfs(root.right, level + 1);

    }

    public boolean isCompleteTree(TreeNode root) {

        TreeNode node = root;
        while(null != node){
            maxLevel++;
            node = node.left;
        }
        return dfs(root,0);
    }
}
