package com.nullzl.interview;

import com.nullzl.util.TreeNode;

public class Interview0402 {

    private TreeNode build(int[] nums,int s, int e){
        if(s > e)
            return null;
        int mid = s + ((e - s) >>> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,s,mid - 1);
        root.right = build(nums,mid + 1,e);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(null == nums || 0 == nums.length)
            return null;

        return build(nums,0,nums.length - 1);
    }
}
