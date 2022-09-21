package com.nullzl.leetcode1100;

import java.util.Arrays;

public class LeetCode1027 {


    public int longestArithSeqLength(int[] nums) {
        int max = 0;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int[][] dp = new int[maxVal + 1][(maxVal << 1) + 1];
        boolean[] exist = new boolean[maxVal + 1];
        int[] set = new int[nums.length];
        int size = 0;
        set[size++] = nums[0];
        exist[nums[0]] = true;
        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 0 ; j < size ; j++){
                int d = nums[i] - set[j] + maxVal;
                dp[nums[i]][d] = Math.max(dp[nums[i]][d] , dp[set[j]][d] + 1);
                max = Math.max(max,dp[nums[i]][d]);
            }
            if(!exist[nums[i]]){
                set[size++] = nums[i];
                exist[nums[i]] = true;
            }
        }
        return max + 1;
    }
}
