package com.nullzl.leetcode100;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;

public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {

        if(null == root){
            return true;
        }

        LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        long preValue = Long.MIN_VALUE;
        while(!stk.isEmpty() || null != curNode){
            while (null != curNode) {
                stk.push(curNode);
                curNode = curNode.left;
            }

            curNode = stk.pop();
            if(curNode.val <= preValue)
                return false;
            preValue = curNode.val;
            curNode = curNode.right;

        }
        return true;


    }
}
