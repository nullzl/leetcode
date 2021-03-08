package com.nullzl.leetcode200;

import com.nullzl.util.ListNode;

public class LeetCode148 {

    private ListNode findNextHead(ListNode node,int k ){
        if(null == node || 0 == k)
            return null;
        for(int i = 1 ; i < k && null != node ; i++){
            node = node.next;
        }
        return node;
    }

    public ListNode sortList(ListNode head) {

        if(null == head)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int i,k = 1;
        ListNode node1,node2,preNode,tailNode,tempNode;
        node1 = dummy.next;
        preNode = dummy;
        while(true){
            if(null == node1){
                k *= 2;
                node1 = dummy.next;
                preNode = dummy;
                continue;
            }
            tailNode = findNextHead(node1,k);
            node2 = (null == tailNode) ? null : tailNode.next;
            if(null == node2 && dummy.next == node1)
                break;
            if(null == node2){
                k *= 2;
                node1 = dummy.next;
                preNode = dummy;
                continue;
            }
            tailNode.next = null;
            for(i = 1; i <= k && null != node1 && null != node2 ; i++){

                while(null != node1 && node1.val <= node2.val){
                    preNode = node1;
                    node1 = node1.next;
                }
                if(null != node1){
                    tempNode = node2.next;
                    preNode.next = node2;
                    node2.next = node1;
                    preNode = node2;
                    node2 = tempNode;
                }else{
                    break;
                }
            }
            if(null == node1){
                preNode.next = node2;
                for(;i<=k && null != node2;i++){
                    preNode = node2;
                    node2 = node2.next;
                }
            }else{
                tailNode.next = node2;
                preNode = tailNode;
            }
            node1 = node2;
        }
        return dummy.next;
    }

    public static  void main(String[] args){
        ListNode node = new ListNode(-1);
        ListNode head = node;
        node.next = new ListNode(5);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(0);
        ListNode temp = new LeetCode148().sortList(head);
        while(null != head){
            System.out.println(head.val);
            head = head.next;
        }

    }


}
