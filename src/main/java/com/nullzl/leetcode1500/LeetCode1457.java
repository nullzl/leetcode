package com.nullzl.leetcode1500;

import com.nullzl.util.TreeNode;

public class LeetCode1457 {

    private boolean valid(int[] map){
        int i,count = 0;
        for(i = 1 ; i <= 9 && count < 2 ; i++){
            count += (map[i] & 1);
        }
        return count < 2;
    }

    private int traverse(TreeNode root,int[] map){
        if(null == root)
            return 0;
        map[root.val]++;
        int count = 0;
        if(null == root.left && null == root.right){
            count = valid(map) ? 1 : 0;
        }else {
            count += traverse(root.left, map);
            count += traverse(root.right, map);
        }
        map[root.val]--;
        return count;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] map = new int[10];
        return traverse(root,map);
    }
}
