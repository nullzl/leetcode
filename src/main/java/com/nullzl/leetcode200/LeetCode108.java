package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode108 {

    private TreeNode buildTree(int[] nums,int start,int end){

        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(nums[start]);

        int mid = (end + start + 1) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums,start,mid-1);
        root.right = buildTree(nums,mid+1,end);
        return root;

    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if(null == nums || 0 == nums.length)
            return null;

        return buildTree(nums,0,nums.length - 1);


    }
}
