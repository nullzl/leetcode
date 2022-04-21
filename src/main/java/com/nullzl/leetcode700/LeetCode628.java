package com.nullzl.leetcode700;

import java.util.Arrays;

public class LeetCode628 {

    private void swap(int[] arr,int i , int j){
        if(i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
    private void maxHeapfy(int[] nums){
        for(int i = 2 ; i > 0 ; i--){
            if(nums[i] < nums[0])
                swap(nums,0,i);
        }
    }
    private void minHeapfy(int[] nums){
        if(nums[1] > nums[0])
            swap(nums,0,1);
    }

    public int maximumProduct(int[] nums) {

        int[] maxHeap = Arrays.copyOf(nums,3);
        int[] minHeap = Arrays.copyOf(nums,2);
        minHeapfy(minHeap);
        minHeap[0] = Math.min(minHeap[0],nums[2]);
        maxHeapfy(maxHeap);
        minHeapfy(minHeap);

        for(int i = 3 ; i < nums.length ; i++){
            if(nums[i] > maxHeap[0]){
                maxHeap[0] = nums[i];
                maxHeapfy(maxHeap);
            }
            if(nums[i] < minHeap[0]){
                minHeap[0] = nums[i];
                minHeapfy(minHeap);
            }
        }
        return Math.max(maxHeap[0] * maxHeap[1] * maxHeap[2],
                Math.max(maxHeap[1],maxHeap[2]) * minHeap[0] * minHeap[1]);

    }
}
