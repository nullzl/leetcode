package com.nullzl.offer;

import com.nullzl.util.Node;

import java.util.HashMap;

public class Offer35 {

    public Node copyRandomList(Node head) {

        Node dummy = new Node(0);
        Node tail = dummy;
        Node node = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(null != node){
            Node tmp = new Node(node.val);
            tail.next = tmp;
            tail = tmp;
            map.put(node,tmp);
            node = node.next;
        }

        node = head;
        tail = dummy.next;
        while (null != node){
            if(null != node.random){
                tail.random = map.get(node.random);
            }
            tail = tail.next;
            node = node.next;
        }
        return dummy.next;

    }
}
