package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode129 {

    int sum  = 0 ;

    private void sum(TreeNode root,int path){
        if(null == root)
            return ;
        path = path * 10 + root.val;
        if(null == root.left && null == root.right) {
            sum += path;
            return ;
        }
        sum(root.left,path);
        sum(root.right,path);

    }

    public int sumNumbers(TreeNode root) {

        if(null == root)
            return 0;
        sum(root,0);
        return sum;
    }
}
