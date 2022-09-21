package com.nullzl.leetcode700;

import com.nullzl.util.TreeNode;

import java.util.*;

public class LeetCode652 {


    List<TreeNode> list = new ArrayList<>();
    private String traverse(HashMap<String,Boolean> map,TreeNode node){
        if(null == node)
            return "#";
        String left = traverse(map,node.left);
        String right = traverse(map,node.right);
        String str = node.val + "," + left + "," + right;
        Boolean f = map.get(str);
        if(null == f)
            map.put(str,false);
        else if(!f) {
            map.put(str, true);
            list.add(node);
        }
        return str;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        HashMap<String,Boolean> map = new HashMap<>();
        traverse(map,root);
        return list;
    }
}
