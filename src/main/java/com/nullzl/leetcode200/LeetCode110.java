package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode110 {

    private int getDepth(TreeNode root){
        if(null == root)
            return 0 ;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(-1 == left || -1 == right)
            return -1;
        if(1 >= Math.abs(right - left)){
            return -1;
        }
        return Math.max(left,right) + 1;
    }

    public boolean isBalanced(TreeNode root) {

        if(null == root)
            return true;

        if(-1 == getDepth(root))
            return false;
        return true;
    }
}
