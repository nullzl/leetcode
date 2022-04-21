package com.nullzl.offer;

import java.util.LinkedList;

public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(null == nums || 0 == nums.length || k < 1 || k > nums.length)
            return null;

        LinkedList<Integer> dqueue = new LinkedList<>();
        int[] rs = new int[nums.length - k + 1];
        int i = 0, j = 0;
        while(j < k - 1){
            while(!dqueue.isEmpty() && dqueue.peekLast() < nums[j]) dqueue.pollLast();
            dqueue.offerLast(nums[j++]);
        }
        while(j < nums.length){
            while(!dqueue.isEmpty() && dqueue.peekLast() < nums[j])
                dqueue.pollLast();
            dqueue.offerLast(nums[j++]);
            rs[i] = dqueue.peekFirst();
            if(nums[i++] == dqueue.peekFirst())
                dqueue.pollFirst();
        }
        return rs;
    }

    class MaxQueue {

        private LinkedList<Integer> queue;
        private LinkedList<Integer> max;

        public MaxQueue() {
            queue = new LinkedList<>();
            max = new LinkedList<>();
        }

        public int max_value() {
            return max.isEmpty() ? -1 : max.peekFirst();
        }

        public void push_back(int value) {
            queue.offerLast(value);
            while(!max.isEmpty() && max.peekLast() < value)
                max.pollLast();
            max.offerLast(value);
        }

        public int pop_front() {
            if(queue.isEmpty()){
                return -1;
            }

            int val = queue.pollFirst();
            if(val == max.peekFirst())
                max.pollFirst();
            return val;
        }
    }
}
