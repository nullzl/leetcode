package com.nullzl.interview;

import com.nullzl.util.TreeNode;

public class Interview0406 {

    TreeNode node = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(null == root || null == p)
            return null;

        TreeNode left = inorderSuccessor(root.left,p);
        if(null != left)
            return left;
        if(p == node)
            return root;
        if(p == root)
            node = p;
        return inorderSuccessor(root.right,p);
    }
}
