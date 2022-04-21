package com.nullzl.offer;

public class Offer39 {

    public int majorityElement(int[] nums) {

        if(null == nums || 0 == nums.length)
            throw new IllegalArgumentException();

        int num = nums[0];
        int count = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(0 == count){
                num = nums[i];
                count = 1;
            }else if(num == nums[i])
                count++;
            else
                count--;
        }
        return num;
    }
}
