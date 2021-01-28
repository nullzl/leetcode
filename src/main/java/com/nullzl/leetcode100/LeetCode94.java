package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        LinkedList<Integer> rs = new LinkedList<Integer>();
        LinkedList<TreeNode> stk = new LinkedList<TreeNode>();
        TreeNode curNode = root;
        while(null != curNode || !stk.isEmpty()){
            if(null != curNode){
                stk.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stk.pop();
                rs.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return rs;
    }
}
