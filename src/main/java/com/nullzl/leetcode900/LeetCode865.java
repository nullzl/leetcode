package com.nullzl.leetcode900;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode865 {

    int maxLevel = -1;
    List<Integer> list = new ArrayList();
    TreeNode subtreeRoot = null;

    public void traverse(TreeNode node,int level){
        if(null == node)
            return ;
        if(level == maxLevel)
            list.add(node.val);
        else if(level > maxLevel){
            maxLevel = level;
            list.clear();
            list.add(node.val);
        }
        traverse(node.left,level + 1);
        traverse(node.right,level+ 1);
    }
    public int findNodes(TreeNode node){
        if(null == node)
            return 0;
        int count = findNodes(node.left);
        if(count < list.size())
            count += findNodes(node.right);
        if(count < list.size()){
            for(int val : list)
                if(val == node.val){
                    count += 1;
                    break;
                }
        }
        if(null == subtreeRoot && count == list.size())
            subtreeRoot = node;
        return count;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        traverse(root,0);
        findNodes(root);
        return subtreeRoot;
    }
}
