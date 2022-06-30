package com.nullzl.offer;

import java.util.Arrays;
import java.util.List;

public class Offer2_100 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int size = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[size];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int min = Integer.MAX_VALUE;
        for(List<Integer> list : triangle){
            min = Integer.MAX_VALUE;
            size = list.size();
            for(int j = size - 1 ; j > 0 ; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
                min = Math.min(min,dp[j]);
            }
            dp[0] += list.get(0);
            min = Math.min(min,dp[0]);
        }
        return min;

    }
}
