package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.Node;

public class LeetCode116 {

    private void connectNode(Node root){

        if(null == root)
            return ;
        Node right = root.right;
        Node left = root.left;
        if(null != right) {
            right.next = (null == root.next ? null : root.next.left);
            connectNode(right);
        }
        if(null != left) {
            left.next = right;
            connectNode(left);
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
