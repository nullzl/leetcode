package com.nullzl.leetcode2200;

import java.util.*;

public class LeetCode2104 {

    public long subArrayRanges(int[] nums) {
        int[] nums1 = Arrays.copyOf(nums,nums.length + 1);
        int[] nums2 = Arrays.copyOf(nums,nums.length + 1);
        nums1[nums.length] = Integer.MAX_VALUE;
        nums2[nums.length] = Integer.MIN_VALUE;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        long maxSum = 0;
        long minSum = 0;

        for(int i = 0 ; i <= nums.length ; i++){
            while(!max.isEmpty() && nums1[i] > nums1[max.peekLast()]){
                int j = max.pollLast();
                int k = max.isEmpty() ? -1 : max.peekLast();
                maxSum += ((long)nums1[j] * (i - j) * (j - k));
            }
            max.offerLast(i);
            while(!min.isEmpty() && nums2[i] < nums2[min.peekLast()]){
                int j = min.pollLast();
                int k = min.isEmpty() ? -1 : min.peekLast();
                minSum += ((long)nums2[j] * (i - j) * (j - k));
            }
            min.offerLast(i);
        }
        return maxSum - minSum;
    }


    public long subArrayRanges1(int[] nums) {

        long sum = 0;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        for(int i = 2 ; i <= nums.length; i++){
            max.clear();
            min.clear();
            int j = 0 ;
            for(; j < i - 1 ; j++){
                while(!max.isEmpty() && nums[max.peekLast()] <= nums[j]) max.pollLast();
                max.offerLast(j);
                while(!min.isEmpty() && nums[min.peekLast()] >= nums[j]) min.pollLast();
                min.offerLast(j);
            }
            for(; j < nums.length ; j++){
                while(!max.isEmpty() && nums[max.peekLast()] <= nums[j]) max.pollLast();
                max.offerLast(j);
                while(!min.isEmpty() && nums[min.peekLast()] >= nums[j]) min.pollLast();
                min.offerLast(j);

                sum += ((long)nums[max.peekFirst()] - (long)nums[min.peekFirst()]);

                if(max.peekFirst() == j - i + 1) max.pollFirst();
                if(min.peekFirst() == j - i + 1) min.pollFirst();
            }
        }
        return sum;
    }
}
