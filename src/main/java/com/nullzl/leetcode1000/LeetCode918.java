package com.nullzl.leetcode1000;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode918 {

    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int minSum = 0 , maxSum = 0 ;
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            min = Math.min(min,sum - maxSum);
            max = Math.max(max,sum - minSum);
            maxSum = Math.max(maxSum,sum);
            minSum = Math.min(minSum,sum);
        }
        return sum == min && max < sum - min ? max : Math.max(max,sum - min);
    }

    public int maxSubarraySumCircular1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{-1,0});
        int len = (nums.length << 1) - 1;
        for(int k = 0 ; k < len ; k++){
            int idx = k % nums.length;
            sum += nums[idx];
            while(!queue.isEmpty() && queue.peekFirst()[0] < k - nums.length)
                queue.pollFirst();
            max = Math.max(max,sum - queue.peekFirst()[1]);
            while(!queue.isEmpty() && queue.peekLast()[1] >= sum)
                queue.pollLast();
            queue.offerLast(new int[]{k,sum});
        }
        return max;
    }
}
