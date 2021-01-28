package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.ListNode;

public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        if(null == head)
            return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curNode = head;
        ListNode preNode = dummyNode;
        ListNode partitionNode = dummyNode;
        while(null != curNode){
            if(curNode.val < x){
                if(partitionNode.next == curNode){
                    partitionNode = curNode;
                    preNode = curNode;
                    curNode = curNode.next;
                }else{
                    preNode.next = curNode.next;
                    ListNode temp = partitionNode.next;
                    partitionNode.next = curNode;
                    partitionNode = curNode;
                    curNode.next = temp;
                    curNode = preNode.next;
                }
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }

}
