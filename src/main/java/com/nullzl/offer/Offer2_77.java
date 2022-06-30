package com.nullzl.offer;

import com.nullzl.util.ListNode;

import java.util.Random;

public class Offer2_77 {

    public ListNode sortList(ListNode head) {

        if(null == head)
            return head;

        ListNode cur = head;
        int min = head.val;
        int max = head.val;
        while(null != cur){
            min = Math.min(min,cur.val);
            max = Math.max(max,cur.val);
            cur = cur.next;
        }

        int delta = min;
        int len = max - min + 1;
        ListNode[][] nodes = new ListNode[len][2];

        cur = head;
        while(null != cur){
            ListNode temp = cur.next;
            int idx = cur.val - delta;
            if(null == nodes[idx][0])
                nodes[idx][1] = cur;
            cur.next = nodes[idx][0];
            nodes[idx][0] = cur;
            cur = temp;
        }

        int i = 0;
        ListNode tail = null;
        while(i < len && null == nodes[i]) i++;
        head = nodes[i][0];
        tail = nodes[i++][1];
        for(; i < len ; i++){
            if(null != nodes[i][0]){
                tail.next = nodes[i][0];
                tail = nodes[i][1];
            }
        }
        return head;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(5000) + 100;
        int k = r.nextInt(len) + 1;
        System.out.print("[" + (r.nextInt(20000) - 10000));
        for(int i = 0 ;i < len ; i++){
            System.out.print("," + (r.nextInt(20000) - 10000));
        }
        System.out.println("]\r\n" + k);
    }
}
