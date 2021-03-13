package com.nullzl.leetcode600;

import com.nullzl.util.TreeNode;

import java.util.*;

public class LeetCode508 {
    int count = 0;

    private int dfs(TreeNode node, HashMap<Integer,Integer> map){
        if(null == node)
            return 0;
        int sum = node.val + dfs(node.left,map) + dfs(node.right,map);
        int c = map.getOrDefault(sum,0) + 1;
        map.put(sum,c);
        count = Math.max(count,c);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {

        if(null == root)
            return new int[0];

        HashMap<Integer,Integer> map = new HashMap<>();
        dfs(root,map);
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        List<Integer> list = new ArrayList<Integer>();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if(count == entry.getValue()){
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
