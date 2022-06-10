package com.nullzl.offer;

import com.nullzl.util.ListNode;

import java.util.PriorityQueue;

public class Offer2_078 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1,n2)->{
            return Integer.compare(n1.val,n2.val);
        });
        for(ListNode node : lists){
            if(null != node){
                heap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            ListNode next = node.next;
            node.next = null;
            tail.next = node;
            tail = node;
            if(null != next)
                heap.offer(next);
        }
        return dummy.next;
    }
}
