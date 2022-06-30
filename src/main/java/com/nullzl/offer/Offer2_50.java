package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.HashMap;

public class Offer2_50 {

    int count = 0;
    HashMap<Integer,Integer> map = new HashMap<>();

    private void traverse(TreeNode node,int sum,int target){
        if(null == node)
            return ;
        sum += node.val;
        count += (map.getOrDefault(sum - target,0));
        int c = map.getOrDefault(sum,0);
        map.put(sum,c + 1);
        traverse(node.left,sum,target);
        traverse(node.right,sum,target);
        map.put(sum,c);
    }

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0,1);
        traverse(root,0,targetSum);
        return count;
    }
}
