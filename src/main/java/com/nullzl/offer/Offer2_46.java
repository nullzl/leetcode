package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer2_46 {

    List<Integer> list = new ArrayList<>();

    private void traverse(TreeNode node,int l){
        if(null == node)
            return ;
       if(l >= list.size())
           list.add(node.val);
       traverse(node.right,l + 1);
       traverse(node.left,l + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        traverse(root,0);
        return list;
    }
}
