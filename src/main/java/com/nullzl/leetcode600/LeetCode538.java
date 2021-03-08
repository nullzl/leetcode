package com.nullzl.leetcode600;

import com.nullzl.util.TreeNode;

public class LeetCode538 {

    private int sum(TreeNode root,int val){
        if(null == root)
            return 0;
        int sum = 0;
        int sumRight = sum(root.right,val);
        sum = root.val + sumRight;
        root.val = sum + val;
        int sumLeft = sum(root.left,root.val);
        sum += sumLeft;
        return sum;
    }

    public TreeNode convertBST(TreeNode root) {

        if(null == root)
            return null;

        sum(root,0);
        return root;
    }
}
