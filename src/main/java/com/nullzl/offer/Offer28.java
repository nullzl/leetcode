package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer28 {

    public boolean match(TreeNode root,TreeNode mirror){
        if(null == root && null == mirror)
            return true;
        if(null == root || null == mirror)
            return false;

        return root.val == mirror.val && match(root.left,mirror.right) && match(root.right,mirror.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(null == root)
            return true;
        return match(root.left,root.right);
    }
}
