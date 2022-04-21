package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.Arrays;

public class Offer32 {

    public int[] levelOrder(TreeNode root) {

        if(null == root)
            return new int[0];

        TreeNode[] queue = new TreeNode[1000];
        int[] rs = new int[1000];
        int bottom = 0,top = 0;
        rs[0] = root.val;
        queue[0] = root;

        while(bottom <= top){
            if(null != queue[bottom].left){
                queue[top+1] = queue[bottom].left;
                rs[++top] = queue[bottom].left.val;
            }
            if(null != queue[bottom].right){
                queue[top + 1]= queue[bottom].right;
                rs[++top] = queue[bottom].right.val;
            }
            bottom++;
        }
        return Arrays.copyOf(rs,top + 1);
    }
}
