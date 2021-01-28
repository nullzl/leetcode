package main.java.com.nullzl.leetcode200;

import main.java.com.nullzl.util.ListNode;

import java.util.HashSet;

public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(null == headA || null == headB)
            return null;

        ListNode cur1 = headA;
        ListNode cur2 = headB;
        boolean reachTail1 = false;
        boolean reachTail2 = false;

        while(null != cur1 && null != cur2){
            if(cur1 == cur2)
                return cur1;
            if(!reachTail1 && null == cur1.next){
                cur1 = headB;
                reachTail1 = true;
            }else{
                cur1 = cur1.next;
            }
            if(!reachTail2 && null == cur2.next){
                cur2 = headA;
                reachTail2 = true;
            }else{
                cur2 = cur2.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if(null == headA || null == headB)
            return null;

        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while(null != cur){
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while(null != cur){
            if(set.contains(cur))
                return cur;
            cur = cur.next;
        }
        return null;
    }
}
