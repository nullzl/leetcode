package com.nullzl.leetcode200;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class LeetCode133 {
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    private Node cloneNode(Node node,HashMap<Node,Node> map){
        if(null != map.get(node))
            return map.get(node);

        Node cloneNode = new Node(node.val,new LinkedList<Node>());
        map.put(node,cloneNode);
        Iterator<Node> iterator = node.neighbors.iterator();
        while(iterator.hasNext()){
            cloneNode.neighbors.add(cloneNode(iterator.next(),map));
        }
        return cloneNode;
    }

    public Node cloneGraph(Node node) {

        HashMap<Node,Node> map = new HashMap<>();

        return cloneNode(node,map);

    }
}
