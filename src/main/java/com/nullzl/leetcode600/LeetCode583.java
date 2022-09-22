package com.nullzl.leetcode600;

public class LeetCode583 {
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[] dp = new int[arr2.length + 1];
        for(int i = 0 ; i < dp.length ; i++){
            dp[i] = i;
        }
        for(int i = 1 ; i <= arr1.length ; i++){
            int prev = dp[0];
            dp[0] = i;
            for(int j = 1 ; j < dp.length ; j++){
                int temp = dp[j];
                if(arr1[i-1] == arr2[j-1])
                    dp[j] = prev;
                else
                    dp[j] = Math.min(dp[j],dp[j-1]) + 1;
                prev = temp;
            }
        }
        return dp[arr2.length];
    }

}
