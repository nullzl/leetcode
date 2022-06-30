package com.nullzl.offer;

import java.util.Arrays;

public class Offer2_102 {
    int delta = 1001;

    private int findTarget(int[][] dp,int[] nums,int target,int len){
        int idx = target + delta;
        if(-1 != dp[len][idx])
            return dp[len][idx];

        dp[len][idx] = findTarget(dp,nums,target + nums[len-1],len - 1)
                + findTarget(dp,nums,target-nums[len-1],len - 1);
        return dp[len][idx];
    }

    public int findTargetSumWays(int[] nums, int target) {

        int[][] dp = new int[nums.length + 1][delta << 1];
        for(int i = 0 ; i < dp.length ; i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i = 0 ; i < (delta << 1) ; i++)
            dp[0][i] = 0;
        dp[0][delta] = 1;
        return findTarget(dp,nums,target,nums.length);
    }
}
