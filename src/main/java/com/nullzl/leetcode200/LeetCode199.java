package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> rs = new LinkedList<>();
        if(null == root)
            return rs;

        TreeNode dummy = new TreeNode(0);
        TreeNode preNode = null,curNode;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offerLast(root);
        list.offerLast(dummy);
        while(!list.isEmpty()){
            curNode = list.pollFirst();
            if(dummy == curNode){
                if(null != preNode && dummy != preNode)
                    rs.add(preNode.val);
                if(dummy != preNode)
                    list.offerLast(dummy);
            }else{
                if(null != curNode.left)
                    list.offerLast(curNode.left);
                if(null != curNode.right)
                    list.offerLast(curNode.right);
            }
            preNode = curNode;
        }
        return rs;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        new LeetCode199().rightSideView(root);
    }
}
