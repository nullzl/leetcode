package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Offer34 {
    List<List<Integer>> result = new LinkedList<>();

    public void countPath(TreeNode root,LinkedList<Integer> path,int target){

        int left = target - root.val;
        path.add(root.val);
        if(0 == left && null == root.left && null == root.right){
            LinkedList<Integer> list = new LinkedList<>();
            list.addAll(path);
            result.add(list);
        }
        if(null != root.left)
            countPath(root.left,path,left);
        if(null != root.right)
            countPath(root.right,path,left);
        path.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(null == root)
            return result;
        LinkedList<Integer> path = new LinkedList<>();
        countPath(root,path,target);
        return result;

    }
}
