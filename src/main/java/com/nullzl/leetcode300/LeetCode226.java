package main.java.com.nullzl.leetcode300;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {

        if(null == root)
            return null;

        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.right = right;
        root.left = left;
        return root;

    }
}
