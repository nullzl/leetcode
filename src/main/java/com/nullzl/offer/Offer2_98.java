package com.nullzl.offer;

import java.util.Arrays;

public class Offer2_98 {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        Arrays.fill(dp[0],1);
        for(int i = 1 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = dp[i-1][j] + (j > 0 ? dp[i][j-1] : 0);
            }
        }
        return dp[m-1][n-1];

    }
}
