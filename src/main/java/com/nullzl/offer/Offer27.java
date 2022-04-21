package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if(null == root)
            return root;

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
