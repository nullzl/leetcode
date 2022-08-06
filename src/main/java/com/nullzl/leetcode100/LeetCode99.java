package com.nullzl.leetcode100;

import com.nullzl.util.TreeNode;

public class LeetCode99 {

    TreeNode prevNode = null;
    TreeNode node1 = null;
    TreeNode node2 = null;

    private void visit(TreeNode node){
        if(null == node)
            return ;
        visit(node.left);
        if(null == prevNode)
            prevNode = node;
        if(null == node1){
            if(node.val < prevNode.val){
                node1 = prevNode;
                node2 = node;
            }
        }else if(node.val < node1.val){
            if(node.val < prevNode.val)
                node2 = node;
        }
        prevNode = node;
        visit(node.right);
    }

    public void recoverTree(TreeNode root) {

        visit(root);
        if(null != node1 && null != node2){
            node1.val = node1.val ^ node2.val;
            node2.val = node1.val ^ node2.val;
            node1.val = node1.val ^ node2.val;
        }

    }
}
