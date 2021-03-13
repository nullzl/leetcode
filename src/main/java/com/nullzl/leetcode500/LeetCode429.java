package com.nullzl.leetcode500;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LeetCode429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>(1000);
        if(null == root)
            return list;
        Node[] nodes = new Node[10000];
        int pos = 0;
        int len = 1;
        int size = 1;
        nodes[0] = root;
        while(pos < size){
            List<Integer> tmp = new ArrayList<Integer>(1000);
            int e = pos + len;
            len = 0;
            while(pos < e){
                Node node = nodes[pos++];
                tmp.add(node.val);
                len += node.children.size();
                Iterator<Node> iterator = node.children.iterator();
                while(iterator.hasNext()){
                    nodes[size++] = iterator.next();
                }
            }
            list.add(tmp);
        }
        return list;
    }
}
