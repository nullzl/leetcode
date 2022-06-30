package com.nullzl.offer;

public class Offer2_96 {

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length())
            return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();

        boolean[] dp = new boolean[arr2.length + 1];
        dp[0] = true;

        for(int i = 1 ; i <= arr2.length ; i++){
            dp[i] = arr2[i-1] == arr3[i-1] && dp[i-1];
        }
        for(int i = 1 ; i <= arr1.length ; i++){
            dp[0] = arr1[i-1] == arr3[i-1] && dp[0];
            for(int j = 1 ; j <= arr2.length ; j++){
                dp[j] = (arr1[i-1] == arr3[i + j - 1] && dp[j])
                        || (arr2[j-1] == arr3[i + j - 1] && dp[j-1]);
            }
        }
        return dp[arr2.length];
    }
}
