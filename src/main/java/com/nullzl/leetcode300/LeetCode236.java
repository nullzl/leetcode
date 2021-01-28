package main.java.com.nullzl.leetcode300;

import main.java.com.nullzl.util.TreeNode;

import java.util.LinkedList;

public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || null == p || null == q)
            throw new IllegalArgumentException();

        LinkedList<TreeNode> nodeStk = new LinkedList<>();
        LinkedList<Integer> countStk = new LinkedList<>();
        TreeNode curNode = root;         //当前需要后根遍历的节点
        TreeNode preNode = null,peekNode;        //前一个输出的节点
        int curCount = 0;
        int preCount = 0;
        int count = 0;
        while(!nodeStk.isEmpty() || null != curNode){
            if(null != curNode){
                if(p == curNode || q == curNode)
                    curCount = 1;
                else
                     curCount = 0;
                nodeStk.push(curNode);
                countStk.push(curCount);
                curNode = curNode.left;
            }else{
                peekNode = nodeStk.peek();
                if(null != peekNode.left && preNode == peekNode.left){
                    count = countStk.pop() + preCount;
                    if(2 == count)
                        return peekNode;
                    countStk.push(count);
                }
                if(null != peekNode.right && preNode == peekNode.right){
                    count = countStk.pop() + preCount;
                    if(2 == count)
                        return peekNode;
                    countStk.push(count);
                }
                if(null != peekNode.right && preNode != peekNode.right){
                    curNode = peekNode.right;
                }else{
                    preNode = nodeStk.pop();
                    preCount = countStk.pop();
                }
            }
        }
        return null;
    }
}
