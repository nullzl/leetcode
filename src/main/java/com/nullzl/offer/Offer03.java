package com.nullzl.offer;

public class Offer03 {

    public void swap(int[] nums,int a,int b){
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public int findRepeatNumber(int[] nums) {

        for(int i = 0 ; i < nums.length ; i++){
            while(i != nums[i]){
                if(nums[i] == nums[nums[i]])
                    return nums[i];
                swap(nums,i,nums[i]);
            }
        }
        //canot reach
        return 0;
    }
}
