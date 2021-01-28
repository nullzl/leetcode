package com.nullzl.leetcode400;

import java.util.Random;

public class LeetCode377 {


    public int combinationSum4(int[] nums, int target) {

        if(0 == target)
            return 1;
        if(null == nums || 0 == nums.length)
            return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1 ; i <= target ; i++){
            for(int num : nums){
                if(i - num >= 0)
                    dp[i] += dp[i - num];
            }
        }
        return dp[target];

    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(10) + 1;
        int[] nums = new int[len];
        int sum = 0;
        nums[0] = r.nextInt(100) + 1;
        sum += nums[0];
        System.out.print("[" + nums[0]);
        for(int i = 1 ; i < len ; i++){
            nums[i] = r.nextInt(100) + 1;
            sum += nums[i];
            System.out.print("," + nums[i]);
        }
        System.out.println("]");
        System.out.println(r.nextInt(sum) + 1);
    }
}
