package com.nullzl.offer;

import java.util.Random;

public class Offer2_92 {

    public int minFlipsMonoIncr(String s) {

        char[] arr = s.toCharArray();
        int[][] dp = new int[arr.length][2];
        dp[0][0] = '0' == arr[0] ? 0 : 1;
        dp[0][1] = '0' == arr[0] ? 1 : 0;

        for(int i = 1; i < arr.length ; i++){
            dp[i][0] = dp[i-1][0] + ('0' == arr[i] ? 0 : 1);
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + ('0' == arr[i] ? 1 : 0);
        }
        return Math.min(dp[arr.length-1][0],dp[arr.length-1][1]);
    }

    public static void main(String[] args){
        int len = 19999;
        Random r =new Random();
        char[] arr = new char[len];
        System.out.print("\"");
        for(int i = 0 ; i < len ; i++){
            arr[i] = (char)('0' + r.nextInt(2));
        }

        System.out.println(new String(arr) + "\"");
    }
}
