package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;

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

    public TreeNode buildTree1(int[] preorder, int[] inorder) {

        if(null == preorder || null == inorder || 0 == preorder.length
                || 0 == inorder.length || preorder.length != inorder.length)
            return null;

        return build(preorder,0,preorder.length - 1,inorder,0,inorder.length-1);

    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        LinkedList<TreeNode> stk = new LinkedList<>();
        int prev = 0, in = 0;
        TreeNode root = new TreeNode(preorder[prev++]);
        stk.push(root);
        while(prev < preorder.length){
            TreeNode node = new TreeNode(preorder[prev++]);
            //寻找父节点
            TreeNode parent = null;
            while(!stk.isEmpty() && stk.peek().val == inorder[in]){
                parent = stk.pop();
                in++;
            }
            //左儿子
            if(null == parent)
                stk.peek().left = node;
            else
                parent.right = node;
            stk.push(node);
        }
        return root;
    }


    int prev =0;
    int in = 0;
    public TreeNode buildHelper(int[] preorder,int[] inorder, long rightVal){
        if(prev == preorder.length)
            return null;
        if(inorder[in] == rightVal) {
            in++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[prev++]);
        root.left = buildHelper(preorder,inorder,root.val);
        root.right = buildHelper(preorder,inorder,rightVal);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(preorder,inorder,Integer.MAX_VALUE + 1L);
    }
}
