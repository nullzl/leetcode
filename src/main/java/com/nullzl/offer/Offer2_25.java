package com.nullzl.offer;

import com.nullzl.util.ListNode;

import java.util.LinkedList;

public class Offer2_25 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stk1 = new LinkedList<>();
        LinkedList<Integer> stk2 = new LinkedList<>();
        while(null != l1){
            stk1.push(l1.val);
            l1 = l1.next;
        }
        while(null != l2){
            stk2.push(l2.val);
            l2 = l2.next;
        }
        int num = 0;
        ListNode node = null;
        while(!stk1.isEmpty() && !stk2.isEmpty()){
            int sum = stk1.pop() + stk2.pop() + num;
            num = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = node;
            node = temp;
        }
        while(!stk1.isEmpty()){
            int sum = stk1.pop() + num;
            num = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = node;
            node = temp;
        }
        while(!stk2.isEmpty()){
            int sum = stk2.pop() + num;
            num = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            temp.next = node;
            node = temp;
        }
        if(0 != num){
            ListNode temp = new ListNode(num);
            temp.next = node;
            node = temp;
        }
        return node;
    }
}
