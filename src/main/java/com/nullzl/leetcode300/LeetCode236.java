package main.java.com.nullzl.leetcode300;

import main.java.com.nullzl.util.TreeNode;

import java.util.LinkedList;

public class LeetCode236 {

    public TreeNode ancestor = null;

    private boolean contains(TreeNode[] nodes,TreeNode node){
        if(null == node)
            return false;
        for(int i = 0 ; i < nodes.length; i++){
            if(nodes[i] == node)
                return true;
        }
        return false;
    }

    //nodes中没有相同的节点
    private int dfs(TreeNode cur,TreeNode[] nodes){

        if(null != ancestor || null == cur)
            return 0;

        int count = contains(nodes,cur) ? 1 : 0;
        count += dfs(cur.left,nodes);
        if(nodes.length != count)
            count += dfs(cur.right,nodes);

        if(null == ancestor && count == nodes.length)
            ancestor = cur;
        return count;
    }

    //适合多个节点公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || null == p || null == q)
            throw new IllegalArgumentException();

        TreeNode[] nodes = new TreeNode[]{p,q};

        //1. 去重，此处可省略

        //2. 递归遍历
        dfs(root,nodes);

        return ancestor;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
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
