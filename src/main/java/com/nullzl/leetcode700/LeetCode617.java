package com.nullzl.leetcode700;

import com.nullzl.util.TreeNode;

public class LeetCode617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(null == t1 && null == t2)
            return null;
        else if(null == t1){
            return t2;
        }else if(null == t2){
            return t1;
        }else{
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left,t2.left);
            t1.right = mergeTrees(t1.right,t2.right);
            return t1;
        }
    }
}
