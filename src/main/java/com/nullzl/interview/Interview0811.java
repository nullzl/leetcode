package com.nullzl.interview;

public class Interview0811 {

    public int waysToChange(int n) {
        int mod = 1000000007;

        int[] nums = new int[]{1,5,10,25};
        int[] dp = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            dp[i] = 1;
        }

        for(int i = 1 ; i < nums.length ; i++){
            for(int j = nums[i] ; j <= n ;j++){
                dp[j] = (dp[j] + dp[j - nums[i]]) % mod;
            }
        }
        return dp[n];
    }
}
