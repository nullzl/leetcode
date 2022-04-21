package com.nullzl.leetcode100;

import java.util.Arrays;

public class LeetCode91 {

    private int count(char[] arr,int s,int[] dp){
        if(-1 != dp[s])
            return dp[s];
        if('0' == arr[s]){
            dp[s] = 0;
        }else if('1' == arr[s]){
            dp[s] = count(arr,s+1,dp);
            dp[s] += (s + 1 < arr.length ? count(arr,s + 2,dp) : 0);
        }else if('2' == arr[s]){
            dp[s] = count(arr,s+1,dp);
            dp[s] += (s + 1 < arr.length && arr[s + 1] >= '0' && arr[s+1] <= '6' ? count(arr,s + 2,dp) : 0);
        }else{
            dp[s] = count(arr,s+1,dp);
        }
        return dp[s];
    }

    public int numDecodings(String s) {

        char[] arr = s.toCharArray();
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp,-1);
        dp[arr.length] = 1;
        return count(arr,0,dp);
    }

    public int numDecodings1(String s) {
        if(null ==  s || 0 == s.length())
            return 0;

        int num1 = 1;
        int num2 = 1;
        int num = 0;

        if(s.length() > 0){
            int code = s.charAt(s.length() - 1) - '0';
            num = code * 10;
            if(0 == code)
                num1 = 0;
        }

        for(int i = s.length() - 2; i >= 0 ; i--){
            int code = s.charAt(i) - '0';
            if(0 == code){
                num2 = num1;
                num1 = 0;
            }else{
                int size = num1;
                num = code * 10 + (num / 10);
                if(num >= 1 && num <= 26){
                    size += num2;
                }
                num2 = num1;
                num1 = size;
            }
        }
        return num1;
    }

    public static void main(String[] args){
        System.out.println(new LeetCode91().numDecodings("226"));
    }

}
