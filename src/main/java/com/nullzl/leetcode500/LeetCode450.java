package com.nullzl.leetcode500;

import com.nullzl.util.TreeNode;

public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode node = root;
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        dummy.left = root;
        TreeNode prev = dummy;
        while(null != node){
            if(key == node.val)
                break;
            prev = node;

            if(key < node.val){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        if(null == node)
            return dummy.left;
        if(node == prev.left)
            prev.left = null != node.left ? node.left : node.right;
        else
            prev.right = null != node.left ? node.left : node.right;
        if(null != node.left && null != node.right){
            TreeNode tmp = node.right;
            node = node.left;
            while(null != node.right) node = node.right;
            node.right = tmp;
        }
        return dummy.left;
    }
}
