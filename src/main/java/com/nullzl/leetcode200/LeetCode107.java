package com.nullzl.leetcode200;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> rs = new LinkedList<List<Integer>>();
        if(null == root)
            return rs;

        TreeNode dummy = new TreeNode(0);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        queue.offerLast(root);
        queue.offerLast(dummy);

        while(!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            if(dummy == cur){
                rs.offerFirst(list);
                if(!queue.isEmpty()){
                    list = new LinkedList<Integer>();
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
