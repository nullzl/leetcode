package com.nullzl.interview;

import com.nullzl.util.TreeNode;

public class Interview0404 {

    private int depth(TreeNode root){
        if(null == root)
            return 0;
        int left = depth(root.left);
        if(-1 == left)
            return -1;
        int right = depth(root.right);
        if(-1 == right)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left,right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return -1 == depth(root) ? false : true;
    }
}
