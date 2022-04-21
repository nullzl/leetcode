package com.nullzl.offer;

import com.nullzl.util.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Offer32_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(null == root)
            return new LinkedList<List<Integer>>();

        List<List<Integer>> list = new LinkedList<>();
        List<TreeNode> cur = new LinkedList<>();
        List<TreeNode> next = new LinkedList<>();
        cur.add(root);

        while(0 != cur.size()){
            List<Integer> line = new LinkedList<>();

            Iterator<TreeNode> iterator = cur.iterator();
            while(iterator.hasNext()){
                TreeNode node = iterator.next();
                line.add(node.val);
                if(null != node.left)
                    next.add(node.left);
                if(null != node.right)
                    next.add(node.right);
            }
            list.add(line);
            cur.clear();
            List<TreeNode> tmp = cur;
            cur = next;
            next = tmp;
        }
        return list;
    }
}
