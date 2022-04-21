package com.nullzl.interview;

import com.nullzl.util.TreeNode;

public class Interview1712 {

    TreeNode tail;

    private void traverse(TreeNode root){
        if(null == root)
            return ;
        traverse(root.left);
        tail.right = root;
        root.left = null;
        tail = root;
        traverse(root.right);
    }


    public TreeNode convertBiNode(TreeNode root) {

        TreeNode dummy = new TreeNode(0);
        tail = dummy;
        traverse(root);
        return dummy.right;
    }
}
