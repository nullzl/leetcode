package com.nullzl.offer;

public class Offer2_12 {

    public int pivotIndex(int[] nums) {

        int prev = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(prev == sum - prev - nums[i])
                return i;
            prev += nums[i];
        }
        return -1;

    }
}
