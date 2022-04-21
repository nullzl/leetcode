package com.nullzl.interview;

import java.util.Arrays;

public class Interview1011 {

    private void swap(int[] nums,int i,int j){
        if(i != j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
    public void wiggleSort1(int[] nums) {
        if(null == nums)
            return ;
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i+=2 ){
            swap(nums,i-1,i);
        }
    }

    public void wiggleSort(int[] nums) {
        if(null == nums)
            return ;
        for(int i = 0 ; i < nums.length - 1 ; i+=2){
            if(nums[i] < nums[i + 1])
                swap(nums,i+1,i);
        }
        for(int i = 1 ; i < nums.length - 1 ;i += 2){
            if(nums[i] > nums[i + 1])
                swap(nums,i,i+1);
        }
    }
}
