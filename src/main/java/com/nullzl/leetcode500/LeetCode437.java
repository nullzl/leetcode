package com.nullzl.leetcode500;

import com.nullzl.util.TreeNode;

import java.util.HashMap;

public class LeetCode437 {

    private int pathCount(TreeNode root,int sum,int parentSum,HashMap<Integer,Integer> map){
        if(null == root)
            return  0;
        int s = root.val + parentSum;
        int count = map.getOrDefault(s - sum,0);
        map.put(s,map.getOrDefault(s,0)  + 1);
        count += pathCount(root.left,sum,s,map);
        count += pathCount(root.right,sum,s,map);
        map.put(s,map.getOrDefault(s,0)  - 1);
        return count;
    }

    public int pathSum(TreeNode root, int sum) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return pathCount(root,sum,0,map);

    }
}
