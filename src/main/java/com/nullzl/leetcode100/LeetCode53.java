package com.nullzl.leetcode100;

public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        int minSum = 0;
        int maxSum = 0x80000000;
        int sum = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            int temp = sum - minSum;
            sum += nums[i];
            if(temp > maxSum)
                maxSum = temp;
            if(sum < minSum)
                minSum = sum;
        }
        return maxSum;
    }
}
