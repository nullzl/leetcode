package com.nullzl.leetcode1200;

import com.nullzl.util.TreeNode;

public class LeetCode1123 {

    TreeNode node = null;
    int maxLevel = -1;
    int count = 0;

    private int[] traverse(TreeNode root,int level){
        if(null == root){
            return new int[]{-1,0};
        }
        int[] rs;
        if(null == root.left && null == root.right) {
            rs = new int[]{level, 1};
        }else {
            int[] left = traverse(root.left, level + 1);
            int[] right = traverse(root.right, level + 1);
            if (left[0] == right[0]) {
                left[1] += right[1];
                rs = left;
            } else if (left[0] > right[0])
                rs = left;
            else
                rs = right;
        }
        if((rs[0] == maxLevel && rs[1] > count) || rs[0] > maxLevel) {
            node = root;
            maxLevel = rs[0];
            count = rs[1];
        }

        return rs;
    }


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        traverse(root,0);
        return node;
    }
}
