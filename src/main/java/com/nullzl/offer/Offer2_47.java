package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer2_47 {

    private int traverse(TreeNode node){
        if(null == node)
            return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        if(0 == left)
            node.left = null;
        if(0 == right)
            node.right = null;
        return left + right + (1 == node.val ? 1 : 0);
    }

    public TreeNode pruneTree(TreeNode root) {
        int c = traverse(root);
        return 0 == c ? null : root;
    }
}
