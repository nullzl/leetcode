package com.nullzl.leetcode1400;

import com.nullzl.util.TreeNode;

import java.util.HashSet;

public class LeetCode1339 {

    long max  = 0;
    HashSet<Long> set =new HashSet<>();

    private long sum(TreeNode node){
        if(null == node)
            return 0 ;
        long sum =  node.val + sum(node.left) + sum(node.right);
        set.add(sum);
        return sum;
    }



    public int maxProduct(TreeNode root) {
        long sum = sum(root);
        for(long left : set){
            max = Math.max(max,(sum-left) * left);
        }
        return (int)(max % 1000000007);
    }
}
