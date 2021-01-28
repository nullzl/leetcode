package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode101 {

    private boolean symmetric(TreeNode root1,TreeNode root2){
        if(null == root1 && null == root2)
            return true;
        if(null == root1 || null == root2 || root1.val != root2.val )
            return false;

        return symmetric(root1.left,root2.right) && symmetric(root1.right,root2.left);
    }

    public boolean isSymmetric(TreeNode root) {

        if(null == root)
            return true;

        return symmetric(root.left,root.right);
    }
}
