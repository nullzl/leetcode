package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer2_44 {

    List<Integer> list = new ArrayList<>();

    private void traverse(TreeNode node,int level){
        if(null == node)
            return ;
        if(level < list.size() && list.get(level) < node.val){
            list.set(level,node.val);
        }else if(level >= list.size())
            list.add(node.val);
        traverse(node.left,level + 1);
        traverse(node.right,level + 1);
    }

    public List<Integer> largestValues(TreeNode root) {

        traverse(root,0);
        return list;
    }
}
