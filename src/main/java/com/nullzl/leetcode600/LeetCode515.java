package com.nullzl.leetcode600;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode515 {

    private void traverse(TreeNode node,int level,List<Integer> max){
        if(null == node)
            return ;

        if(level == max.size())
            max.add(node.val);
        else
            max.set(level,Math.max(max.get(level),node.val));
        traverse(node.left,level + 1,max);
        traverse(node.right,level + 1,max);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max = new ArrayList<>();
        traverse(root,0,max);
        return max;
    }
}
