package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        LinkedList<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(null == root)
            return rs;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode(0);
        boolean direction = true;
        queue.offerLast(root);
        queue.offerLast(dummy);
        LinkedList<Integer> list = new LinkedList<Integer>();
        while(!queue.isEmpty()){
            TreeNode cur ;
            if(direction){
                cur = queue.pollFirst();
            }else{
                cur = queue.pollLast();
            }
            if(dummy == cur){
                rs.add(list);
                if(!queue.isEmpty()){
                    direction = !direction;
                    list = new LinkedList<Integer>();
                    if(direction)
                        queue.offerLast(dummy);
                    else
                        queue.offerFirst(dummy);
                }
            }else{
                list.add(cur.val);
                if(direction){
                    if(null != cur.left)
                        queue.offerLast(cur.left);
                    if(null != cur.right)
                        queue.offerLast(cur.right);
                }else{
                    if(null != cur.right)
                        queue.offerFirst(cur.right);
                    if(null != cur.left)
                        queue.offerFirst(cur.left);
                }
            }
        }

        return rs;

    }
}
