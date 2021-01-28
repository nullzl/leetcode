package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.TreeNode;

public class LeetCode124 {

    int maxSum = 0 ;

    private int maxPath(TreeNode root){
        if(null == root.left && null == root.right){
            if(root.val > maxSum)
                maxSum = root.val;
            return root.val;
        }
        int max;
        int sum;

        if(null != root.left && null == root.right){
            max = maxPath(root.left);
            sum = max;
        }else if(null == root.left && null != root.right){
            max = maxPath(root.right);
            sum = max;
        }else{
            int left = maxPath(root.left);
            int right = maxPath(root.right);
            max = Math.max(left,right);
            sum = Math.max(max,left+right);
        }
        sum = Math.max(sum + root.val,root.val);
        max = Math.max(max+root.val,root.val);
        if(sum > maxSum)
            maxSum = sum;
        return max;
    }

    public int maxPathSum(TreeNode root) {

        if(null == root)
            return 0;
        maxSum = root.val;
        maxPath(root);
        return maxSum;

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(-4);
        System.out.println(new LeetCode124().maxPathSum(root));
    }

}
