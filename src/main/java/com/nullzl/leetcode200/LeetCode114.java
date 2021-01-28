package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode114 {

    public void flatten(TreeNode root) {
        if(null == root)
            return ;

        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode cur = root;
        root.left = null;
        flatten(left);
        root.right = left;
        while(null != cur.right)
            cur = cur.right;
        flatten(right);
        cur.right = right;

    }
}
