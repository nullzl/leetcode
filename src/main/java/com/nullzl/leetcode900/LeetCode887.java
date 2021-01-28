package com.nullzl.leetcode900;

public class LeetCode887 {


    public int superEggDrop(int K, int N) {

        int[][] dp = new int[K][N+1];
        for(int j = 0 ; j < N ; j++) {
            dp[0][j] = j;
        }
        for(int i = 1 ; i < K ; i++)
            dp[i][0] = 0;
        int i = 1;
        for(; dp[K-1][i-1] < N && i <= N ; i++){
            for(int j = 1 ; j < K ; j++){
                dp[j][i] = 1 + dp[j-1][i-1] + dp[j][i-1];
            }
        }
        return i - 1;
    }
    public  static void main(String[] args){
        System.out.println(new LeetCode887().superEggDrop(1,1));
    }
}
