package com.nullzl.leetcode1400;

import java.util.Arrays;

public class LeetCode1312 {

    public int compute(String s,int[][] dp,int i , int j){
        if(i < 0 && j >= dp.length)
            return 0;
        if(i < 0)
            return dp.length - j;
        if(j >= dp.length)
            return i + 1;
        if(-1 == dp[i][j]){
            dp[i][j] = s.charAt(i) == s.charAt(j)
                    ? compute(s,dp,i-1,j+1)
                    : Math.min(compute(s,dp,i,j+1),compute(s,dp,i-1,j)) + 1;
        }
        return dp[i][j];
    }


    public int minInsertions(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        int count = Integer.MAX_VALUE;
        for(int i = 0 ; i < s.length() ; ){
            int y = i + 1;
            while(y < s.length() && s.charAt(y) == s.charAt(i))y++;
            count = Math.min(count,compute(s,dp,i-1,y));
            i = y;
        }
        return count;
    }
}
