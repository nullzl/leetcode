package com.nullzl.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Offer2_61 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> lists = new LinkedList<>();
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((op1,op2) ->{
            return Integer.compare(nums1[op1[0]] + nums2[op1[1]],nums1[op2[0]] + nums2[op2[1]]);
        });
        for(int i = 0 ; i < nums1.length ; i++)
            heap.offer(new Integer[]{i,0});

        while(!heap.isEmpty() && k-- > 0){
            Integer[] nums = heap.poll();
            Integer[] arr = new Integer[]{nums1[nums[0]],nums2[nums[1]]};
            lists.add(Arrays.asList(arr));
            if(nums[1] + 1 < nums2.length){
                heap.offer(new Integer[]{nums[0],nums[1] + 1});
            }
        }
        return lists;
    }
}
