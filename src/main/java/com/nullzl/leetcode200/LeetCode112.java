package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode112 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(null == root)
            return false;

        if(null == root.left && null == root.right){
            if(sum == root.val)
                return true;
            else
                return false;
        }
        sum -= root.val;
        return hasPathSum(root.left,sum ) || hasPathSum(root.right,sum);


    }
}
