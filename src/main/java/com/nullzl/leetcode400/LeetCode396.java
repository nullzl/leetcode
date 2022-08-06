package com.nullzl.leetcode400;

public class LeetCode396 {

    public int maxRotateFunction(int[] nums) {
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            max += (i * nums[i]);
            sum += nums[i];
        }
        int prev = max;
        for(int i = nums.length - 1 ; i > 0 ; i--){
            prev = prev + sum - nums.length * nums[i];
            max = Math.max(max,prev);
        }
        return max;
    }
}
