package com.nullzl.interview;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Interview0409 {

    private void generate(List<List<Integer>> rs,List<Integer> list,List<Integer> list1,List<Integer> list2){
        if(list1.isEmpty() && list2.isEmpty()){
            List<Integer> tmp = new LinkedList<>(list);
            rs.add(tmp);
            return ;
        }else if(list1.isEmpty() || list2.isEmpty()){
            List<Integer> tmp = new LinkedList<>(list);
            tmp.addAll(list1.isEmpty() ? list2 : list1);
            rs.add(tmp);
            return ;
        }

        int val  = list1.remove(0);
        list.add(val);
        generate(rs,list,list1,list2);
        list1.add(0,val);
        list.remove(list.size() - 1);
        val = list2.remove(0);
        list.add(val);
        generate(rs,list,list1,list2);
        list2.add(0,val);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> BSTSequences1(TreeNode root) {
        List<List<Integer>> rs= new LinkedList<>();
        if(null == root) {
            rs.add(new LinkedList<>());
            return rs;
        }

        List<List<Integer>> left = BSTSequences(root.left);
        List<List<Integer>> right = BSTSequences(root.right);
        List<Integer> list = new LinkedList<>();
        for(List<Integer> list1 : left){
            for(List<Integer> list2 : right){
                generate(rs,list,list1,list2);
            }
        }
        for(List<Integer> item : rs){
            item.add(0,root.val);
        }
        return rs;
    }


    private void generate(List<List<Integer>> rs,LinkedList<Integer> item,LinkedList<TreeNode> nodes){
        if(nodes.isEmpty()) {
            rs.add(new LinkedList<>(item));
            return;
        }

        for(int i = 0 ; i < nodes.size() ; i++){
            TreeNode node = nodes.remove(i);
            item.add(node.val);
            if(null != node.left) nodes.add(node.left);
            if(null != node.right) nodes.add(node.right);
            generate(rs,item,nodes);
            if(null != node.left) nodes.removeLast();
            if(null != node.right) nodes.removeLast();
            nodes.add(i,node);
            item.removeLast();
        }

    }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> rs = new LinkedList<>();
        LinkedList<Integer> item = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if(null != root)
            nodes.add(root);
        generate(rs,item,nodes);
        return rs;
    }
}
