package com.nullzl.interview;

public class Interview1617 {

    public int maxSubArray(int[] nums) {

        int min = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            max = Math.max(max,sum - min);
            min = Math.min(min,sum);
        }
        return max;
    }
}
