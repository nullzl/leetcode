package com.nullzl.leetcode700;

import com.nullzl.util.TreeNode;

public class LeetCode654 {

    private TreeNode generate(int[] nums,int s , int e){
        if(s > e)
            return null;
        if(s == e)
            return new TreeNode(nums[s]);
        int max = s;
        for(int i = s + 1 ; i <= e ; i++) {
            if (nums[i] > nums[max])
                max = i;
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = generate(nums,s , max - 1);
        root.right= generate(nums,max + 1, e);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return generate(nums,0,nums.length - 1);
    }
}
