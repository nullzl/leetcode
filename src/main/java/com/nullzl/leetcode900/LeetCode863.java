package com.nullzl.leetcode900;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode863 {

    boolean findTarget = false;

    private int traversal(TreeNode node,TreeNode target,int k,List<Integer> list){
        if(null == node || findTarget)
            return -1;
        int dis = -1,left,right;
        if(target == node){
            findTarget = true;
            dis = 0;
            getDistance(node.left,k,dis,list);
            getDistance(node.right,k,dis,list);
        }else if(-1 != (left = traversal(node.left,target,k,list))){
            dis = left + 1;
            getDistance(node.right,k,dis,list);
        }else if(-1 != (right = traversal(node.right,target,k,list))){
            dis = right + 1;
            getDistance(node.left,k,dis,list);
        }
        if(k == dis){
            list.add(node.val);
        }
        return dis;
    }

    private void getDistance(TreeNode node,int k,int dis,List<Integer> list){
        if(null == node)
            return ;
        dis += 1;
        if(dis < k){
            getDistance(node.left,k,dis,list);
            getDistance(node.right,k,dis,list);
        }else if(dis == k){
            list.add(node.val);
        }

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new ArrayList<Integer>(501);
        traversal(root,target,K,list);
        return list;
    }
}
