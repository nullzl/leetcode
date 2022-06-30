package com.nullzl.offer;

import com.nullzl.util.Util;

public class Offer2_90 {

    private int robRange(int[] nums,int s , int e){
        int[][] dp = new int[nums.length][2];
        if(s >= nums.length || e <= s)
            return 0;
        dp[s][1] = nums[s];
        for(int j = s + 1 ; j < e ; j++){
            dp[j][0] = Math.max(dp[j-1][0],dp[j-1][1]);
            dp[j][1] = dp[j-1][0] + nums[j];
        }
        return Math.max(dp[e-1][0],dp[e-1][1]);
    }

    public int rob(int[] nums) {

        return Math.max(robRange(nums,0,nums.length - 1),
                robRange(nums,1,nums.length - 2) + nums[nums.length - 1]);

    }

    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(100,0,1000));
    }
}
