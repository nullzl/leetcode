package com.nullzl.leetcode1200;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1161 {

    private void traverse(TreeNode root, int level, List<Integer> list){
        if(null == root)
            return ;
        if(level < list.size()){
            list.set(level,list.get(level) + root.val);
        }else{
            list.add(root.val);
        }
        traverse(root.left,level + 1,list);
        traverse(root.right,level + 1,list);
    }

    public int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,0,list);
        int val = Integer.MIN_VALUE;
        int level = -1;
        for(int i = 0 ; i < list.size(); i++){
            int v = list.get(i);
            if(v > val){
                val = v;
                level = i;
            }
        }
        return level + 1;
    }
}
