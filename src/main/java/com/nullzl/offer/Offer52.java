package com.nullzl.offer;

import com.nullzl.util.ListNode;

public class Offer52 {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        if(null == headA || null == headB)
            return null;

        ListNode[] p1 = new ListNode[]{headA,headB};
        ListNode[] p2 = new ListNode[]{headB,headA};
        int i = 0 , j = 0;

        while(null != p1[1] || null != p2[1]){
            if(null == p1[i] && 0 == i){
                i++;
            }else if(null == p2[j] && 0 == j){
                j++;
            }else if(p1[i] == p2[j])
                return p1[i];
            else{
                p1[i] = p1[i].next;
                p2[j] = p2[j].next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB)
            return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = null == p1 ? headB : p1.next;
            p2 = null == p2 ? headA : p2.next;
        }
        return p1;
    }
}
