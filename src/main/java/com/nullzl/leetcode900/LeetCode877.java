package com.nullzl.leetcode900;

public class LeetCode877 {

    public boolean stoneGame(int[] piles) {

        int[] dp = new int[piles.length];
        int[] sum = new int[piles.length];
        sum[0] = piles[0];
        for(int i = 1 ; i < piles.length ; i++){
            sum[i] = sum[i-1] + piles[i];
        }

        for(int i = piles.length - 1; i >= 0 ; i--){
            dp[i] = piles[i];
            for(int j = i + 1 ; j < piles.length ; j++){
                int s = sum[j] - (i > 0 ? sum[i - 1] : 0);
                dp[j] = Math.max(
                        s - dp[j-1] + piles[j],
                        s - dp[j] + piles[i]
                );
            }
        }
        return dp[piles.length - 1] > (sum[piles.length - 1] - dp[piles.length - 1]);

    }
}
