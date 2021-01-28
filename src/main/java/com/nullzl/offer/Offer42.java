package com.nullzl.offer;

public class Offer42 {

    public int maxSubArray(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;

        int max = nums[0];
        int sum = nums[0];
        int minSum = Math.min(max,0);
        for(int i = 1; i < nums.length  ; i++){
            sum += nums[i];
            max = Math.max(max,sum - minSum);
            minSum = Math.min(minSum,sum);
        }
        return max;
    }
}
