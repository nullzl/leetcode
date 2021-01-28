package com.nullzl.leetcode500;

import java.util.Random;

public class LeetCode474 {

    public int findMaxForm(String[] strs, int m, int n) {

        if(null == strs || (0 == m && 0 == n))
            return 0;

        int[][] dp = new int[m+1][n+1];

        for(int i = 0 ; i < strs.length ; i++){
            if(null == strs[i] || 0 == strs[i].length())
                continue;
            int a = 0, b = 0;
            for(int c = 0 ; c < strs[i].length() ; c++){
                if('0' == strs[i].charAt(c))
                    a++;
                else
                    b++;
            }

            for(int x = m  ; x >= a ; x--){
                for(int y = n ; y >= b ; y--){
                    dp[x][y] = Math.max(dp[x][y],1 + dp[x - a][y - b]);
                }
            }

        }
        return  dp[m][n];
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(600) + 1;
        String[] strs = new String[len];

        System.out.print("[");
        for(int i = 0 ; i < len ; i++){
            StringBuffer tmp = new StringBuffer();
            int k = r.nextInt(100) + 1;
            for(int j = 0 ; j < k ; j++){
                tmp.append(r.nextBoolean() ? '1' : '0');
            }
            System.out.print( "\"" + tmp.toString() + "\"" + ",");
        }

        System.out.print("]\r\n" + (r.nextInt(100) + 1) + "\r\n" + (r.nextInt(100) + 1) + "\r\n");

    }
}
