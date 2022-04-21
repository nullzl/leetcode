package com.nullzl.leetcode600;

import com.nullzl.util.TreeNode;

public class LeetCode572 {

    public boolean equals(TreeNode node1,TreeNode node2){
        if(null == node1 && null == node2)
            return true;
        if(null == node1 || null == node2)
            return false;
        if(node1.val != node2.val)
            return false;
        return equals(node1.left,node2.left) && equals(node1.right,node2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(null == root)
            return false;

        return equals(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
