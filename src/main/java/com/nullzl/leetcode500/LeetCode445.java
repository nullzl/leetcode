package com.nullzl.leetcode500;

import main.java.com.nullzl.util.ListNode;

public class LeetCode445 {

    private ListNode addHead(ListNode list,int val){
        ListNode temp = new ListNode(val);
        temp.next = list;
        return temp;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(null == l1)
            return l2;
        if(null == l2)
            return l1;

        ListNode s1,s2,f1,f2,rs,temp,preNode;
        s1 = f1 = l1;
        s2 = f2 = l2;
        rs = null;
        while(null != f1.next && null != f2.next){
            f1 = f1.next;
            f2 = f2.next;
        }
        while(null != f1.next){
            rs = addHead(rs,s1.val);
            s1 = s1.next;
            f1 = f1.next;
        }
        while(null != f2.next){
            rs = addHead(rs,s2.val);
            s2 = s2.next;
            f2 = f2.next;
        }
        while(null != s1){
            rs = addHead(rs,s1.val + s2.val);
            s1 = s1.next;
            s2 = s2.next;
        }
        int add = 0;
        preNode = null;
        while(null != rs){
            int sum = add + rs.val;
            add = sum / 10;
            rs.val = sum % 10;
            temp = rs.next;
            rs.next = preNode;
            preNode = rs;
            rs = temp;
        }
        if(0 != add){
            preNode = addHead(preNode,add);
        }
        return preNode;
    }

    public ListNode toList(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for(int i = 1 ; i < array.length ; i++){
            ListNode node = new ListNode(array[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }

    public static void main(String[] args){
        LeetCode445 lc = new LeetCode445();
        ListNode l1 = lc.toList(new int[]{7,2,4,3});
        ListNode l2 = lc.toList(new int[]{5,6,4});
        lc.addTwoNumbers(l1,l2);
    }

}
