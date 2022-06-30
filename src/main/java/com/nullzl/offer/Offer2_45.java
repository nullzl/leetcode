package com.nullzl.offer;

import com.nullzl.util.TreeNode;

public class Offer2_45 {

    int level = -1;
    int value = 0;

    private void traverse(TreeNode node,int l){
        if(null == node)
            return ;
        if(l > level){
            level = l;
            value = node.val;
        }
        traverse(node.left,l + 1);
        traverse(node.right, l + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        traverse(root,0);
        return value;
    }
}
