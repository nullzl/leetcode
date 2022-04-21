package com.nullzl.offer;

import com.nullzl.util.Node;

public class Offer36 {

    static class NodeList{
        public Node head;
        public Node tail;

        public NodeList(Node h,Node t){
            head = h;
            tail = t;
        }
    }

    public NodeList toList(Node node){
        if(null == node)
            return null;
        Node head,tail;
        NodeList leftList = toList(node.left);
        NodeList rightList = toList(node.right);
        if(null != leftList){
            leftList.tail.right = node;
            node.left = leftList.tail;
        }
        if(null != rightList){
            node.right = rightList.head;
            rightList.head.left = node;
        }
        head = null == leftList ? node : leftList.head;
        tail = null == rightList ? node : rightList.tail;
        return new NodeList(head,tail);
    }

    public Node treeToDoublyList(Node root) {

        NodeList list = toList(root);

        if(null == list)
            return null;
        list.head.left = list.tail;
        list.tail.right = list.head;
        return list.head;

    }
}
