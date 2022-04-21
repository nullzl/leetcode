package com.nullzl.leetcode600;

import java.util.Arrays;

public class LeetCode518 {

    public int change(int amount, int[] coins) {

        int[][] dp = new int[amount + 1][coins.length + 1];
        Arrays.fill(dp[0],1);
        for(int i = 1 ; i <= amount ; i++){
            for(int j = 1 ; j <= coins.length ; j++){
                dp[i][j] = 0;
                int num = i;
                while(num >= 0){
                    dp[i][j] += dp[num][j-1];
                    num -= coins[j-1];
                }
            }
        }
        return dp[amount][coins.length];
    }
}
