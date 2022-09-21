package com.nullzl.leetcode900;

import java.util.Iterator;
import java.util.PriorityQueue;

public class LeetCode870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {

        int[] set = new int[nums1.length];
        int size = 0;
        int[] ans = new int[nums1.length];
        PriorityQueue<Integer> heap1 = new PriorityQueue<>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<>((op1,op2) ->{
            return Integer.compare(nums2[op1],nums2[op2]);
        });
        for(int n : nums1)
            heap1.offer(n);
        for(int i = 0 ; i < nums2.length ; i++)
            heap2.offer(i);

        while(!heap1.isEmpty()){
            int idx = heap2.peek();
            int n = nums2[idx];
            while(!heap1.isEmpty() && heap1.peek() <= n){
                set[size++] = heap1.poll();
            }
            if(!heap1.isEmpty())
                ans[heap2.poll()] = heap1.poll();
        }
        int i = 0 ;
        Iterator<Integer> iterator  = heap2.iterator();
        while(iterator.hasNext()){
            ans[iterator.next()] = set[i++];
        }
        return ans;
    }
}
