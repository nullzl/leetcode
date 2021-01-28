package com.nullzl.leetcode1000;

public class LeetCode912 {
    private void swap(int[] nums,int o1,int o2){
        if(o1 != o2){
            nums[o1] = nums[o1] ^ nums[o2];
            nums[o2] = nums[o1] ^ nums[o2];
            nums[o1] = nums[o1] ^ nums[o2];
        }
    }

    private int partition(int[] nums,int s ,int e){
        int k = s - 1;
        for(int i = s ; i < e ; i++){
            if(nums[i] <= nums[e]){
                swap(nums,i,++k);
            }
        }
        swap(nums,++k,e);
        return k;
    }

    private void quickSort(int[] nums,int s,int e){
        if(s >= e)
            return ;
        int k = partition(nums,s,e);
        quickSort(nums,s,k-1);
        quickSort(nums,k+1,e);
    }

    public int[] sortArray(int[] nums) {

        if(null == nums)
            return null;
        quickSort(nums,0,nums.length-1);
        return nums;
    }
}
