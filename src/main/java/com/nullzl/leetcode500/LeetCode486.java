package com.nullzl.leetcode500;

import java.util.Random;

public class LeetCode486 {

    public boolean PredictTheWinner(int[] nums) {

        int[] dp = new int[nums.length];
        int sum = 0;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            sum += nums[i];
            int intervalSum = nums[i];
            dp[i] = nums[i];
            for(int j = i + 1; j < nums.length ; j++) {
                intervalSum += nums[j];
                dp[j] = intervalSum - Math.min(dp[j],dp[j-1]);
            }
        }

        return (dp[nums.length-1] << 1) >= sum;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(20) + 1;
        System.out.print("[" + r.nextInt(10000001));
        for(int i = 1; i < len ; i++)
            System.out.print("," + r.nextInt(10000001));
        System.out.println("]");
    }
}
