package com.nullzl.interview;

import com.nullzl.util.TreeNode;

public class Interview0408 {

    TreeNode parent = null;

    private int dfs(TreeNode root,TreeNode p, TreeNode q){
        if(null == root)
            return 0;
        int count = dfs(root.left,p,q);
        if(2 == count)
            return 2;
        count += root == p || root == q ? 1 : 0;
        if(2 == count) {
            parent = root;
            return 2;
        }
        int right = dfs(root.right,p,q);
        if(2 == right)
            return 2;
        count += right;
        if(2 == count){
            parent = root;
        }
        return count;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root)
            return null;
        dfs(root,p,q);
        return parent;
    }
}
