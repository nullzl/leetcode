package com.nullzl.LeetCode1400;

import com.nullzl.util.TreeNode;

public class LeetCode1302 {

    int max = -1;
    int sum = 0;

    private void traverse(TreeNode root,int level){
        if(null == root)
            return ;
        if(null != root.left || null != root.right){
            traverse(root.left,level + 1);
            traverse(root.right,level + 1);
        }
        if(level == max)
            sum += root.val;
        else if(level > max){
            max = level;
            sum = root.val;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        traverse(root,0);
        return sum;
    }
}
