package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode105 {

    private TreeNode build(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
        if(prestart > preend)
            return null;
        if(prestart == preend)
            return new TreeNode(preorder[prestart]);

        TreeNode root = new TreeNode(preorder[prestart]);
        int i ;
        for(i = instart ; i <= inend ; i++){
            if(preorder[prestart] == inorder[i])
                break;
        }
        root.left = build(preorder,prestart + 1,prestart + i - instart,inorder,instart,i-1);
        root.right = build(preorder,prestart + i - instart + 1,preend,inorder,i+1,inend);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(null == preorder || null == inorder || 0 == preorder.length
                || 0 == inorder.length || preorder.length != inorder.length)
            return null;

        return build(preorder,0,preorder.length - 1,inorder,0,inorder.length-1);

    }
}
