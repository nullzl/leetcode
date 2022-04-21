package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer68 {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if(root.val == p.val || root.val == q.val)
            return root;
        else if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor1(root.left,p,q);
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor1(root.right,p,q);
        else
            return root;

    }
    public TreeNode rs = null;
    public int dfs(TreeNode root,TreeNode p ,TreeNode q){
        if(null != rs || null == root)
            return 0;
        int t = root == p || root == q ? 1 : 0;
        t += dfs(root.left,p,q);
        if(2 == t){
            rs = root;
            return 0;
        }
        t += dfs(root.right,p,q);
        if(2 == t){
            rs = root;
            return 0;
        }
        return t;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return rs;
    }
}
