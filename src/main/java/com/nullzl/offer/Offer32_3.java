package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Offer32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> rs = new LinkedList<>();
        if(null == root)
            return rs;

        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        cur.push(root);
        int line = 0;
        while(!cur.isEmpty()){

            List<Integer> list = new LinkedList<>();
            while(!cur.isEmpty()){
                TreeNode node = cur.pop();
                list.add(node.val);
                TreeNode first = (0 == (1 & line)) ? node.left : node.right;
                TreeNode sec = (0 == (1 & line)) ? node.right : node.left;
                if(null != first)
                    next.push(first);
                if(null != sec)
                    next.push(sec);
            }
            rs.add(list);
            line++;
            LinkedList<TreeNode> tmp = cur;
            cur = next;
            next = tmp;
        }
        return rs;
    }
}
