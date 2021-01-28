package com.nullzl.leetcode800;

public class LeetCode718 {

    public int findLength(int[] A, int[] B) {

        if(A.length < B.length)
            return  findLength(B,A);

        int[] dp = new int[B.length];
        int max = 0;
        for(int i = 0 ; i < B.length ; i++) {
            dp[i] = A[0] == B[i] ? 1 : 0;
            max = Math.max(dp[i],max);
        }

        for(int i = 1  ; i < A.length ; i++){
            int pre = dp[0];
            dp[0] = A[i] == B[0] ? 1 : 0;
            max = Math.max(dp[0],max);
            for(int j = 1 ; j < B.length ;j++) {
                int tmp = dp[j];
                dp[j] = B[j] == A[i] ? pre + 1 : 0;
                max = Math.max(max,dp[j]);
                pre = tmp;
            }
        }
        return max;
    }
}
