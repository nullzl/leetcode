package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(null == root)
            return rs;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode(0);
        queue.offerLast(root);
        queue.offerLast(dummy);

        LinkedList<Integer> list =new LinkedList<Integer>();
        while(!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            if(dummy == cur){
                rs.add(list);
                if(!queue.isEmpty()){
                    list =new LinkedList<Integer>();
                    queue.offerLast(dummy);
                }
            }else{
                list.add(cur.val);
                if(null != cur.left)
                    queue.offerLast(cur.left);
                if(null != cur.right)
                    queue.offerLast(cur.right);
            }
        }
        return rs;

    }
}
