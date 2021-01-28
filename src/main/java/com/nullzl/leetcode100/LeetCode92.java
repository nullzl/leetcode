package main.java.com.nullzl.leetcode100;

import main.java.com.nullzl.util.ListNode;

public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode lastNode = dummyNode;
        ListNode preNode = dummyNode;
        ListNode mNode = dummyNode;
        ListNode curNode = head;
        int i ;
        for(i = 1; null != curNode && i <= n ; i++){
            if(i == m){
                lastNode = preNode;
                mNode = curNode;
                preNode = curNode;
                curNode = curNode.next;
            }else if(i > m && i <= n){
                ListNode temp = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = temp;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        lastNode.next = preNode;
        mNode.next = curNode;
        return dummyNode.next;
    }

}
