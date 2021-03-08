package com.nullzl.leetcode300;

import java.util.Arrays;

public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;

        int[] dp = new int[nums.length];
        int len = 1;
        dp[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            int k = Arrays.binarySearch(dp,0,len,nums[i]);
            if(k < 0 ){
                k = - (k + 1);
                dp[k] = nums[i];
                if(k == len)
                    len++;
            }
        }
        return len;
    }
}
