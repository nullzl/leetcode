package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode113 {

    public void getPath(TreeNode root, int sum, List<List<Integer>> rs, LinkedList<Integer> list){

        if(null == root)
            return ;

        if(null == root.left && null == root.right){
            if(root.val == sum){
                LinkedList<Integer> item = new LinkedList<>();
                item.addAll(list);
                item.add(root.val);
                rs.add(item);
                return ;
            }
        }

        list.offerLast(root.val);
        sum -= root.val;
        getPath(root.left,sum,rs,list);
        getPath(root.right,sum,rs,list);
        list.pollLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(null == root)
            return rs;
        LinkedList<Integer> list = new LinkedList<Integer>();
        getPath(root,sum,rs,list);
        return rs;
    }
}
