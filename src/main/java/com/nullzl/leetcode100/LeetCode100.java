package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(null == p && null == q)
            return true;
        if(null == p || null == q || p.val != q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
