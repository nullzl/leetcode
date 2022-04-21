package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;

public class LeetCode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        LinkedList<TreeNode> stk = new LinkedList<>();
        int idx = inorder.length - 1;
        TreeNode dummy = new TreeNode(400000);
        stk.push(dummy);
        for(int i = postorder.length - 1 ; i >= 0 ; i--){
            TreeNode node = new TreeNode(postorder[i]);
            if(!stk.isEmpty() && stk.peek().val != inorder[idx])
                stk.peek().right = node;
            else{
                TreeNode parent = null;
                while(!stk.isEmpty() && stk.peek().val == inorder[idx]){
                    idx--;
                    parent = stk.pop();
                }
                parent.left = node;
            }
            stk.push(node);
        }
        return dummy.right;
    }

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

    public TreeNode buildTree1(int[] inorder, int[] postorder) {

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
