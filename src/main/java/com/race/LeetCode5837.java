package com.race;

import java.util.Arrays;

public class LeetCode5837 {

    public boolean compare(String a,String b){
        if(a.length() > b.length())
            return true;
        else if(a.length() < b.length())
            return false;
        else
            return a.compareTo(b) >= 0;
    }

    private int dfs(int[][] dp,char[] arr,String last,String num,int j,int m,int n){
        int mod = 1000000007;
        if(-1 != dp[m][n])
            return dp[m][n];
        if(j == arr.length){
            if(num.length() == 0 || compare(num,last)){
                return 1;
            }
            else {
                return 0;
            }
        }
        String val = num + String.valueOf(arr[j]);
        if(val.equals("0"))
            return 0;
        int count = 0;
        if(compare(val,last) && j != arr.length - 1)
            count = dfs(dp,arr,val,"",j+1,j + 1,val.length()) % mod;
        count = (count + dfs(dp,arr,last,val,j+1,m,n)) % mod;
        dp[m][n]= count;
        return count;
    }



    public int numberOfCombinations(String num) {

        char[] arr = num.toCharArray();
        String last = "0";
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for(int[] nums : dp){
            Arrays.fill(nums,-1);
        }
        return dfs(dp,arr,last,"",0,0,1);
    }

    public static void main(String[] args){
        System.out.println(new LeetCode5837().numberOfCombinations("9999999999999"));
    }
}
