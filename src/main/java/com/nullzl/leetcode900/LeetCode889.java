package com.nullzl.leetcode900;

import com.nullzl.util.TreeNode;

public class LeetCode889 {

    private TreeNode build(int[] pre,int[] post,int s1, int s2,int len){
        if(0 == len)
            return null;
        TreeNode root = new TreeNode(pre[s1]);
        if(1 == len)
            return root;

        int val = pre[s1 + 1];
        int j = 1;
        for(; j < len && post[s2 - j] != val ; j++);
        root.left = build(pre,post,s1 + 1,s2 - j,len - j);
        root.right = build(pre,post,s1 + 1 + len - j, s2 - 1,j - 1);
        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder,postorder,0,postorder.length - 1,preorder.length);
    }
}
