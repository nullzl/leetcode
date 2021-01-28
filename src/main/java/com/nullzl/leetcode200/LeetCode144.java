package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        LinkedList<Integer> rs= new LinkedList<Integer>();
        if(null == root)
            return rs;

        LinkedList<TreeNode> stk = new LinkedList<>();
        stk.push(root);

        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            rs.add(node.val);
            if(null != node.right)
                stk.push(node.right);
            if(null != node.left)
                stk.push(node.left);
        }
        return rs;

    }
}
