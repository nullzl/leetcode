package com.nullzl.leetcode1600;

import com.nullzl.util.TreeNode;

import java.util.Arrays;

public class LeetCode1530 {

    int len = (1 << 10) + 1;
    int count = 0;

    private int[] traverse(TreeNode root,int dis,int level){
        if(null == root)
            return null;
        if(null == root.left && null == root.right){
            int[] rs = new int[len];
            Arrays.fill(rs,level,len - 1,1);
            return rs;
        }
        int[] left = traverse(root.left,dis,level + 1);
        int[] right = traverse(root.right,dis,level + 1);
        if(null == root.left || null == root.right)
            return null == root.left ? right : left;

        int s = level + 1;
        int sum = dis + (level << 1);
        int e = Math.min(len - 1, sum - 1);
        for(int i = s ; i <= e ; i++){
            count += (left[i] * (right[sum - i] - right[sum - i - 1]));
        }
        for(int i = 0 ; i < left.length ; i++){
            left[i] += right[i];
        }
        return left;
    }

    public int countPairs(TreeNode root, int distance) {
        
        traverse(root,distance,0);
        return count;
    }
}
