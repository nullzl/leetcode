package com.nullzl.leetcode1100;

import java.util.Random;

public class LeetCode1092 {

    public String shortestCommonSupersequence(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        String[] dp = new String[arr2.length + 1];
        dp[0] = "";
        for(int i = 1 ; i < dp.length ; i++){
            dp[i] = str2.substring(0,i);
        }

        for(int i = 1 ; i <= str1.length() ; i++){
            String prev = dp[0];
            dp[0] = str1.substring(0,i);
            for(int j = 1 ; j < dp.length ; j++){
                String temp = dp[j];
                if(arr1[i-1] == arr2[j-1])
                    dp[j] = prev + String.valueOf(arr1[i-1]);
                else
                    dp[j] = dp[j].length() > dp[j-1].length() ? dp[j-1] + String.valueOf(arr2[j-1])
                            : dp[j] + String.valueOf(arr1[i-1]);
                prev = temp;
            }
        }
        return dp[arr2.length];
    }

    public static void main(String[] args){
        Random r = new Random();
        int len1 = r.nextInt(500) + 400;
        int len2 = r.nextInt(500) + 400;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(int i = 0 ; i < len1 ; i++){
            s1.append((char)('a' + r.nextInt(26)));
        }
        for(int i = 0 ; i < len2 ; i++)
            s2.append((char)('a' + r.nextInt(26)));
        System.out.println("\"" + s1.toString() + "\""   );
        System.out.println("\"" + s2.toString() + "\""   );
    }

}
