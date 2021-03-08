package com.nullzl.leetcode200;

import com.nullzl.util.Node;

public class LeetCode117 {

    private void connectNode(Node root){
        if(null == root)
            return ;

        Node next = null;
        Node cur = root.next;
        while(null != cur && null == next){
            next = (null != cur.left ? cur.left : cur.right);
            cur = cur.next;
        }

        if(null != root.right){
            root.right.next = next;
            next = root.right;
            connectNode(root.right);
        }
        if(null != root.left){
            root.left.next = next;
            connectNode(root.left);
        }

    }

    public Node connect(Node root) {

        if(null == root)
            return null;
        root.next = null;
        connectNode(root);
        return root;
    }
}
