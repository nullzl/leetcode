package com.nullzl.leetcode500;

import java.util.PriorityQueue;

public class LeetCode480 {




    public double[] medianSlidingWindow(int[] nums, int k) {

        if(null == nums || k > nums.length)
            return new double[0];

        double[] ans = new double[nums.length - k + 1];
        PriorityQueue<Integer>  maxHeap = new PriorityQueue<>((o1,o2) ->{
            return o2.compareTo(o1);
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(maxHeap.isEmpty() || nums[i] <= maxHeap.peek())
                maxHeap.add(nums[i]);
            else
                minHeap.add(nums[i]);
            if(i >= k){
                if(!maxHeap.isEmpty() && nums[i - k] <= maxHeap.peek())
                    maxHeap.remove(nums[i-k]);
                else
                    minHeap.remove(nums[i-k]);
            }
            while(minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.remove());
            while(maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.remove());
            if(i >= k - 1) {
                ans[i - k + 1] = maxHeap.size() == minHeap.size()
                        ? ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0 : maxHeap.peek();

            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        double[] ans = new LeetCode480().medianSlidingWindow(nums,3);
        for(double d : ans)
            System.out.println(d);
    }
}
