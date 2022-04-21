package com.nullzl.leetcode500;

public class LeetCode494 {

    /**
     * 递归解法
     * 利用初始数组和小于1000，可确定可达到的s范围-1000，到1000，所以也可使用动态规划
     */

    public int sumWays(int[] nums,int k, int s){
        if(-1 == k){
            if(0 == s)
                return 1;
            else
                return 0;
        }

        return sumWays(nums,k-1,s + nums[k]) +
                sumWays(nums,k-1,s -nums[k]);
    }

    public int findTargetSumWays1(int[] nums, int S) {

        return sumWays(nums,nums.length - 1,S);

    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        int[] prev = new int[nums.length];
        prev[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++)
            prev[i] = prev[i-1] + nums[i];
        sum = prev[nums.length - 1];
        if(target < -sum || target > sum)
            return 0;
        int[][] dp = new int[nums.length + 1][(sum << 1) + 1];
        dp[0][sum] = 1;
        for(int i = 1 ; i <= nums.length ; i++){
            for(int j = sum - prev[i-1] ; j <= sum + prev[i-1] ; j++){
                dp[i][j] = (j + nums[i-1] < dp[i].length ? dp[i-1][j + nums[i-1]] : 0)
                        + (j - nums[i-1] >= 0 ?dp[i-1][j - nums[i-1]] : 0);

                if(i == nums.length && j == target + sum)
                    break;
            }
        }
        return dp[nums.length][target + sum];
    }
}
