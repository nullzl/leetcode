package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer2_49 {

    int sum = 0;

    private void traverse(TreeNode node,int num){
        if(null == node)
            return ;
        num = num * 10 + node.val;
        if(null == node.left && null == node.right) {
            sum += num;
            return ;
        }
        traverse(node.left,num);
        traverse(node.right,num);
    }

    public int sumNumbers(TreeNode root) {

        traverse(root,0);
        return sum;
    }
}
