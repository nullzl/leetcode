package com.nullzl.interview;

import com.nullzl.util.TreeNode;

import java.util.HashMap;

public class Interview0412 {

    public int count(HashMap<Integer,Integer> map,TreeNode root,int previous,int sum){
        if(null == root)
            return 0;
        previous += root.val;
        int count = map.getOrDefault(previous - sum , 0);
        int val = map.getOrDefault(previous,0);
        val++;
        map.put(previous,val);
        count += count(map,root.left,previous,sum);
        count += count(map,root.right,previous,sum);
        val--;
        map.put(previous,val);
        return count;
    }

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return count(map,root,0,sum);
    }
}
