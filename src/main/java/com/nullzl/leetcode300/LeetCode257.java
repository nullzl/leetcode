package com.nullzl.leetcode300;

import com.nullzl.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {

    List<String> paths = new ArrayList<>();

    public void traversal(TreeNode node,String path){
        if(null == node)
            return ;
        path += ("->" + node.val);
        if(null != node.left)
            traversal(node.left,path);
        if(null != node.right)
            traversal(node.right,path);
        if(null == node.left && null == node.right)
            paths.add(path);
    }


    public List<String> binaryTreePaths(TreeNode root) {
        if(null == root)
            return paths;
        String path = String.valueOf(root.val);
        if(null == root.right && null == root.left){
            paths.add(path);
            return paths;
        }
        traversal(root.left,path);
        traversal(root.right,path);
        return paths;
    }
}
