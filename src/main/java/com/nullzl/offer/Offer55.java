package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer55 {

    public int maxDepth(TreeNode root) {

        if(null == root)
            return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));

    }


    public int verify(TreeNode root){
        if(null == root)
            return 0;
        int left = verify(root.left);
        int right = verify(root.right);
        if(-1 == left || -1 == right)
            return -1;
        else if(Math.abs(right - left) <= 1)
            return Math.max(left,right) + 1;
        else
            return -1;
    }

    public boolean isBalanced(TreeNode root) {
        return -1 != verify(root);
    }
}
