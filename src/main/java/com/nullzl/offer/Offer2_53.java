package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer2_53 {

    TreeNode preNode = null;

    private TreeNode traverse(TreeNode node,TreeNode p){
        if(null == node)
            return null;
        TreeNode n = traverse(node.left,p);
        if(null != n)
            return n;
        if(preNode == p)
            return node;
        else
            preNode = node;
        return traverse(node.right,p);
    }



    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode temp = traverse(root,p);
        return temp;
    }
}
