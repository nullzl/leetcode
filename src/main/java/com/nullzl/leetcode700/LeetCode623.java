package com.nullzl.leetcode700;

import com.nullzl.util.TreeNode;

public class LeetCode623 {

    private void traversal(TreeNode root, int val,int depth,int d){
        if(null == root || d >= depth)
            return ;
        if(d == depth - 1){
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            return ;
        }
        traversal(root.left,val,depth,d + 1);
        traversal(root.right,val,depth,d + 1);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(1 == depth){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        traversal(root,val,depth,1);
        return root;

    }
}
