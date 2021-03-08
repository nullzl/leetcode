package com.nullzl.leetcode200;

public class LeetCode121 {
    public int maxProfit(int[] prices) {

        int max = 0;
        if(null == prices || 0 == prices.length)
            return max;
        int min = prices[0];

        for(int i = 1; i < prices.length ; i++){

            int profit = prices[i] - min;
            if(profit > max)
                max = profit;

            if(prices[i] < min){
                min = prices[i];
            }
        }

        return max;
    }
}
