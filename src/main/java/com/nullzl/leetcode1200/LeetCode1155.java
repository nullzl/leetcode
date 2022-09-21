package com.nullzl.leetcode1200;

import java.util.Arrays;

public class LeetCode1155 {

    public int numRollsToTarget(int n, int k, int target) {
        int num = 1000000007;
        int[] dp = new int[target + 1];
        Arrays.fill(dp,1,Math.min(target,k) + 1,1);
        for(int i = 2 ; i <= n ; i++){
            for(int j = target ; j >= 1 ; j--){
                dp[j] = 0;
                for(int x = 1 ; x <= k; x++){
                    int count = j - x >= 0 ? dp[j - x] : 0;
                    dp[j] = (dp[j] + count) % num;
                }
            }
        }
        return dp[target];
    }
}
