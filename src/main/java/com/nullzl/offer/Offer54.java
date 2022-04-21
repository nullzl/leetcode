package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer54 {

    public  TreeNode result = null;

    public int find(TreeNode root,int k){
        if(null != result)
            return -1;

        if(null == root)
            return 0;

        int count = find(root.right,k);
        if(-1 == count)
            return -1;
        else if(count == k - 1){
            result = root;
            return -1;
        }else{
            int left = find(root.left, k - 1 - count);
            return -1 == left ? -1 : count + 1 + left;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        find(root,k);
        return result.val;
    }
}
