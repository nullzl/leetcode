package com.nullzl.offer;

public class Offer21 {

    public void swap(int[] nums,int i , int j){
        if(i < j){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    public int[] exchange(int[] nums) {

        if(null == nums || 0 == nums.length)
            return nums;
        for(int i = 0 , j = nums.length - 1 ; i < j ; ){
            while (0 != (1 & nums[i])  && i < j) i++;
            while( 0 == (1 & nums[j]) && i < j) j--;
            swap(nums,i,j);
        }
        return nums;
    }
}
