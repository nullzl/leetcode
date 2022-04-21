package com.nullzl.leetcode700;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;

public class LeetCode662 {

    class Seq{
        int left = -1;
        int right = -1;

        public Seq(int s){
            left = s;
            right = s;
        }

        public void update(int s){
            right = s;
        }
    }

    private void traverse(ArrayList<Seq> list, TreeNode root,int level, int seq){
        if(null == root)
            return;
        Seq s = null;
        if(level < list.size()) {
            s = list.get(level);
            s.update(seq);
        } else{
            s = new Seq(seq);
            list.add(s);
        }
        traverse(list,root.left,level + 1,(seq << 1) + 1);
        traverse(list,root.right,level + 1,(seq<<1) + 2);
    }

    public int widthOfBinaryTree(TreeNode root) {
        ArrayList<Seq> list = new ArrayList<>();
        traverse(list,root,0,0);
        int max = 0;
        for(Seq s : list){
            max = Math.max(s.right - s.left + 1,max);
        }
        return max;
    }
}
