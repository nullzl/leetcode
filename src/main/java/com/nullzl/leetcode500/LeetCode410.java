package com.nullzl.leetcode500;

public class LeetCode410 {

    public int sum(int[] sum,int i, int j){
        return sum[j] - (i == 0 ? 0 : sum[i-1]);
    }

    public int binarySearch(int[] dp,int[] sum,int i,int j){
        int s = i;
        int e = j;
        while(s <= e){
            int mid = s + ((e - s) >> 1);
            int v = sum(sum,mid,j);
            if(v == dp[mid - 1])
                return v;
            if(v < dp[mid - 1])
                e = mid - 1;
            else
                s  = mid + 1;
        }

        if(i == s)
            return dp[i - 1];
        else if(s == j + 1)
            return sum(sum,j,j);
        else
            return Math.min(dp[s-1],sum(sum,s-1,j));
    }


    public int splitArray(int[] nums, int m) {

        int[][] dp = new int[m][nums.length];
        dp[0][0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            nums[i] += nums[i - 1];
            dp[0][i] = nums[i];
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = i ; j < nums.length ; j++){
                dp[i][j] = binarySearch(dp[i-1],nums,i,j);
            }
        }
        return dp[m-1][nums.length - 1];

    }

    public static void main(String[] args){
        System.out.println(new LeetCode410().splitArray(
                new int[]{7,2},
                2
        ));
    }
}
