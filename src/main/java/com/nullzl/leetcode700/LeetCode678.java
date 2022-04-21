package com.nullzl.leetcode700;

public class LeetCode678 {

    private boolean check(char[] arr,int s,int left,int right,int[][][] dp){
        if(s == arr.length)
            return left == right;
        if(0 != dp[s][left][right])
            return dp[s][left][right] == 1;
        if('(' == arr[s]){
            dp[s][left][right] = left + 1 >= right && check(arr,s + 1,left + 1,right,dp) ? 1 : -1;
        }else if(')' == arr[s]){
            dp[s][left][right] = left >= right + 1 && check(arr,s + 1,left,right + 1,dp) ? 1 : -1;
        }else{
            dp[s][left][right] = check(arr,s + 1,left,right,dp)
                    || check(arr,s+1,left + 1,right,dp)
                    || (left > right && check(arr,s+1,left,right + 1,dp)) ? 1 : -1;
        }
        return dp[s][left][right] == 1;
    }

    public boolean checkValidString1(String s) {
        if(null == s || 0 == s.length())
            return true;
        int[][][] dp = new int[s.length()][s.length() + 1][s.length() + 1];
        return check(s.toCharArray(),0,0,0,dp);

    }

    public boolean checkValidString(String s) {
        if(null == s || 0 == s.length())
            return true;
        char[] arr = s.toCharArray();
        int low = 0, high = 0;
        for(int i = 0 ;i < arr.length ; i++){
            if('(' == arr[i]){
                low++;
                high++;
            }else if(')' == arr[i]){
                low = Math.max(0,low-1);
                high--;
            }else{
                high++;
                low = Math.max(0,low-1);
            }
            if(high < 0)
                return false;
        }
        return 0 == low;
    }
}
