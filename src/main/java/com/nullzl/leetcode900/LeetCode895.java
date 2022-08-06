package com.nullzl.leetcode900;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode895 {
}

class FreqStack {

    int[] stk = new int[20001];
    boolean[] removed = new boolean[20001];
    int size = 0;
    HashMap<Integer,Integer> map =new HashMap<>();
    PriorityQueue<int[]> heap = new PriorityQueue<>((op1,op2) ->{
        if(op1[0] == op2[0])
            return -Integer.compare(op1[1],op2[1]);
        return -Integer.compare(op1[0],op2[0]);
    });

    public FreqStack() {

    }

    public void push(int val) {
        while(size > 0 && removed[size - 1]) {
            removed[--size] = false;
        }
        stk[size++] = val;
        int count = map.getOrDefault(val,0) + 1;
        map.put(val,count);
        heap.offer(new int[]{count,size - 1});
    }

    public int pop() {
        while(size > 0 && removed[size - 1]) {
            removed[--size] = false;
        }
        int[] num = heap.poll();
        int idx = num[1];
        removed[idx] = true;
        map.put(stk[idx],num[0] - 1);
        return stk[idx];
    }
}
