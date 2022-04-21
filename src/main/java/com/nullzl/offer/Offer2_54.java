package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer2_54 {

    int sum = 0;
    private void traverse(TreeNode root){
        if(null == root)
            return ;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
}
