package com.nullzl.leetcode300;

import com.nullzl.util.TreeNode;

public class LeetCode222 {

    public int countNodes1(TreeNode root) {
        if(null == root)
            return 0;
        return countNodes1(root.left) + countNodes1(root.right) + 1;

    }

    public int countNodes(TreeNode root) {

        if(null == root)
            return 0;

        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode left = root;
        TreeNode right  = root;
        while(null != left.left){
            leftDepth++;
            left = left.left;
        }
        while(null != right.right){
            rightDepth++;
            right = right.right;
        }

        //底层填满
        if(leftDepth == rightDepth){
            return ((1 << (leftDepth + 1)) - 1) ;
        }

        TreeNode node = root;
        int depth = 0;
        int count = 0;
        while (null != node){
            TreeNode preNode = node.left;
            if(null == preNode){
                node = null ;
                continue;
            }
            depth++;
            int preDepth = depth;
            while(null != preNode.right){
                preDepth++;
                preNode = preNode.right;
            }
            if(preDepth == leftDepth){
                node = node.right;
                count += (1 << (leftDepth - depth));
            }else{
                node = node.left;
            }
        }
        return count + ((1 << leftDepth) - 1);
    }





}
