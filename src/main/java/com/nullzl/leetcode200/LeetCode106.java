package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode106 {

    private TreeNode build(int[] inorder,int instart,int inend,int[] postorder, int poststart,int postend){
        if(instart > inend)
            return null;
        if(instart == inend)
            return new TreeNode(inorder[instart]);

        int i ;
        for(i = instart ; i <= inend  ; i++){
            if(inorder[i] == postorder[postend])
                break;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        root.left = build(inorder,instart,i-1,postorder,poststart,poststart+i-instart-1);
        root.right = build(inorder,i+1,inend,postorder,poststart+i-instart,postend-1);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(null == inorder || null == postorder ||
            0 == inorder.length || 0 == postorder.length
            || inorder.length != postorder.length)
            return null;
        return build(inorder,0,inorder.length - 1 , postorder,0,postorder.length -1);

    }
    public static void main(String[] args){
        int[] in = {1,2,3};
        int[] post = {1,2,3};
        new LeetCode106().buildTree(in,post);
    }
}
