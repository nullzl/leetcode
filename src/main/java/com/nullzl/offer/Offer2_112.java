package com.nullzl.offer;

import java.util.Random;

public class Offer2_112 {

    public int dfs(int[][] matrix,int[][] dp,int i , int j,int cur){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || cur >= matrix[i][j])
            return 0;
        if(0 != dp[i][j])
            return dp[i][j];

        int path = 0;
        path = Math.max(path,dfs(matrix,dp,i+1,j,matrix[i][j]));
        path = Math.max(path,dfs(matrix,dp,i-1,j,matrix[i][j]));
        path = Math.max(path,dfs(matrix,dp,i,j+1,matrix[i][j]));
        path = Math.max(path,dfs(matrix,dp,i,j-1,matrix[i][j]));
        dp[i][j] = path + 1;
        return dp[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0 ;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                max = Math.max(max,dfs(matrix,dp,i,j,-1));
            }
        }
        return max;
    }

    public static void main(String[] args){
        Random r = new Random();
        int m = r.nextInt(100) + 100;
        int n = r.nextInt(100) + 100;
        System.out.print("[");
        for(int i = 0 ; i < m ; i++){
            System.out.print("[" + r.nextInt(Integer.MAX_VALUE));
            for(int j = 0 ; j < n-1 ; j++){
                System.out.print("," + r.nextInt(Integer.MAX_VALUE));
            }
            System.out.print("],");
        }
        System.out.print("]");
    }
}
