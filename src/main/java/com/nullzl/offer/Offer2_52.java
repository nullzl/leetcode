package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer2_52 {

    private TreeNode[] traverse(TreeNode node){
        if(null == node)
            return new TreeNode[]{null,null};
        TreeNode[] left = traverse(node.left);
        TreeNode[] right = traverse(node.right);
        if(null != left[1])
            left[1].right = node;
        node.right = right[0];
        node.left = null;
        return new TreeNode[]{
                null != left[0] ? left[0] : node,
                null != right[1] ? right[1] : node
        };
    }

    public TreeNode increasingBST(TreeNode root) {
        return traverse(root)[0];
    }
}
