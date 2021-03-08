package com.nullzl.leetcode200;

import java.util.Iterator;
import java.util.LinkedList;

public class LeetCode123 {

    public int maxProfit(int[] prices) {

        if(null == prices || 0 == prices.length){
            return 0;
        }

        int min = prices[0];
        int[] leftProfits = new int[prices.length];
        int[] rightProfits = new int[prices.length];
        for(int i = 1; i < prices.length ; i++){
            int profit = prices[i] - min;
            leftProfits[i] = (profit > leftProfits[i-1] ? profit : leftProfits[i-1]);
            if(prices[i] < min)
                min = prices[i];
        }

        int max = prices[prices.length -1];
        for(int i = prices.length - 2; i >= 0 ; i--){
            int profit = max - prices[i];
            rightProfits[i] = (profit > rightProfits[i+1] ? profit : rightProfits[i+1]);
            if(prices[i] > max)
                max = prices[i];
        }

        int maxProfit = leftProfits[prices.length - 1];
        for(int i = 0 ; i < prices.length - 1 ; i++){
            int profit = leftProfits[i] + rightProfits[i+1];
            if(profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] nums = {6,1,3,2,4,7};
        System.out.println(new LeetCode123().maxProfit(nums));
    }
}
