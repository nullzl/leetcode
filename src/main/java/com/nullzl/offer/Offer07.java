package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer07 {

    public TreeNode build(int[] preorder,int ps,int pe,int[] inorder,int is,int ie){
        if(ps > pe)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int k = is;
        for(;inorder[k] != preorder[ps]; k++);
        int len = k - is;
        TreeNode left = build(preorder,ps + 1,ps + len,inorder,is,k-1);
        TreeNode right = build(preorder,ps + len + 1,pe,inorder,k + 1,ie);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null == preorder || 0 == preorder.length)
            return null;
        return build(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);

    }
}
