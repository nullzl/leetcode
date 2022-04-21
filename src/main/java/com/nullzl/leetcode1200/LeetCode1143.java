package com.nullzl.leetcode1200;

public class LeetCode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int[] dp = new int[arr2.length + 1];
        for(int i = 1 ; i <= arr1.length ; i++){
            int prev = dp[0];
            for(int j = 1 ; j <= arr2.length ; j++){
                int tmp = dp[j];
                dp[j] = arr1[i - 1] == arr2[j - 1]
                        ? prev + 1
                        : Math.max(dp[j],dp[j-1]);
                prev = tmp;
            }
        }
        return dp[arr2.length];
    }
}
