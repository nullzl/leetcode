package main.java.com.nullzl.leetcode300;

import main.java.com.nullzl.util.TreeNode;

import java.util.HashMap;

public class LeetCode230 {

    private int countNodes(TreeNode root, HashMap<TreeNode,Integer> map){
        if(null == root)
            return 0;
        int count = map.getOrDefault(root,0);
        if(0 == count){
            count = countNodes(root.left,map)
                    + countNodes(root.right,map) + 1;
            map.put(root,count);
        }
        return count;
    }

    private int kthSmallest(TreeNode root,int k,HashMap<TreeNode,Integer> map){
        int leftCount = countNodes(root.left,map);
        if(k == leftCount + 1)
            return root.val;
        if(leftCount >= k)
            return kthSmallest(root.left,k,map);
        return kthSmallest(root.right,k - leftCount - 1,map);
    }

    public int kthSmallest(TreeNode root, int k) {

        HashMap<TreeNode,Integer> map = new HashMap<>();
        return kthSmallest(root,k,map);

    }
}
