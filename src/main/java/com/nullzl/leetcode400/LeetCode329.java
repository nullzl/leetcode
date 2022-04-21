package com.nullzl.leetcode400;

public class LeetCode329 {

    private int dfs(int[][] m,int[][] dp,int i , int j, int val){
        if(i < 0 || i >= m.length || j < 0 || j >= m[0].length)
            return 0;
        if(m[i][j] <= val)
            return 0;
        if(0 == dp[i][j]) {
            int count = 0;
            count = Math.max(count, dfs(m, dp, i + 1, j, m[i][j]));
            count = Math.max(count, dfs(m, dp, i - 1, j, m[i][j]));
            count = Math.max(count, dfs(m, dp, i, j + 1, m[i][j]));
            count = Math.max(count, dfs(m, dp, i, j - 1, m[i][j]));
            dp[i][j] = count + 1;
        }
        return dp[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                max = Math.max(max,dfs(matrix,dp,i,j,-1));
            }
        }
        return max;
    }
}
