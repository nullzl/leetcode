package com.nullzl.leetcode600;

public class LeetCode474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] arrs = new int[strs.length][2];
        int i = 0;
        for(String str : strs){
            char[] arr = str.toCharArray();
            for(char ch : arr){
                arrs[i][ch - '0']++;
            }
            i++;
        }

        int[][][] dp = new int[arrs.length + 1][m + 1][n + 1];
        for(i = 1 ; i < dp.length ; i++){
            for(int j = 0 ; j <= m ; j++){
                for(int k = 0 ;  k <= n ; k++){
                    int[] left = new int[]{j - arrs[i-1][0],k - arrs[i-1][1]};
                    dp[i][j][k] = left[0] >= 0 && left[1] >= 0 ? dp[i-1][left[0]][left[1]] + 1 : -1;
                    dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j][k]);
                }
            }
        }
        return dp[arrs.length][m][n];
    }
}
