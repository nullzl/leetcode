package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode95 {

    LinkedList<TreeNode>[] cache ;

    private TreeNode copy(TreeNode root,int offset){
        if(null == root)
            return null;
        TreeNode rs = new TreeNode(root.val + offset);
        rs.left = (null == root.left ? null : copy(root.left,offset));
        rs.right = (null == root.right ? null : copy(root.right,offset));
        return rs;
    }

    private LinkedList<TreeNode> getTrees(int start,int end){


        if(null != this.cache[end-start]){
            LinkedList<TreeNode> rs = new LinkedList<TreeNode>();
            List<TreeNode> list = this.cache[end - start];
            Iterator<TreeNode> iterator = list.iterator();
            while(iterator.hasNext()){
                rs.add(copy(iterator.next(),start - 1));
            }
            return rs;
        }

        LinkedList<TreeNode> rs = new LinkedList<TreeNode>();
        if(start == end){
            TreeNode root = new TreeNode(start);
            rs.add(root);
            return rs;
        }

        LinkedList<TreeNode> rightList = getTrees(start + 1,end);
        Iterator<TreeNode> rightIterator = rightList.iterator();
        while(rightIterator.hasNext()){
            TreeNode root = new TreeNode(start);
            root.right = rightIterator.next();
            rs.add(root);
        }

        LinkedList<TreeNode> leftList = getTrees(start,end-1);
        Iterator<TreeNode> leftIterator = leftList.iterator();
        while(leftIterator.hasNext()){
            TreeNode root = new TreeNode(end);
            root.left = leftIterator.next();
            rs.add(root);
        }

        for(int i = start + 1;  i < end ; i++){
            leftList = getTrees(start,i-1);
            rightList = getTrees(i+1,end);
            leftIterator = leftList.iterator();

            while(leftIterator.hasNext()){
                TreeNode left = leftIterator.next();
                rightIterator = rightList.iterator();
                while(rightIterator.hasNext()){
                    TreeNode right = rightIterator.next();
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    rs.add(root);
                }
            }
        }
        return rs;

    }

    /**
     * 另一解法：有1到n的所有二叉搜索树，生成1到n+1的二叉搜索树
     * 节点n+1为根，每个1到n的二叉搜索树作为其左子树
     * 对于每个1到n的二叉搜索树，从根节点开始最右边这条路径遍历，每个节点替换为节点n+1，原剩余的子树成为节点n+1的左子树
     * 直到路径上的最后一个节点，其右节点为null。将其右节点变为节点n+1
     */
    public List<TreeNode> generateTrees(int n) {

        if(n <= 0){
            return new LinkedList<TreeNode>();
        }
        this.cache = new LinkedList[n];
        for(int i = 1 ; i <= n ; i++)
            this.cache[i-1] = getTrees(1,i);
        return this.cache[n-1];
    }
    public static void main(String[] args){
        System.out.println(new LeetCode95().generateTrees(4).size());
    }
}
