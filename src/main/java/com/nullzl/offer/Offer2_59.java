package com.nullzl.offer;

import java.util.PriorityQueue;

public class Offer2_59 {

    class KthLargest {

        int k;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for(int num : nums){
                if(heap.size() < this.k)
                    heap.offer(num);
                else if(num > heap.peek()){
                    heap.poll();
                    heap.offer(num);
                }
            }
        }

        public int add(int val) {
            if(heap.size() < this.k)
                heap.offer(val);
            else if(val > heap.peek()){
                heap.poll();
                heap.offer(val);
            }
            return heap.peek();
        }
    }
}
