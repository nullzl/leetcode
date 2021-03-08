package com.nullzl.leetcode800;

public class LeetCode714 {

    public int maxProfit(int[] prices, int fee) {

        if(null == prices || 0 == prices.length)
            return 0;

        int[] profit = new int[2];
        profit[1] = -prices[0];
        int temp1,temp2;
        for(int i = 1 ; i < prices.length ; i++){
            temp1 = profit[0];
            temp2 = profit[1];

            profit[0] = Math.max(temp1,temp2 + prices[i] - fee);
            profit[1] = Math.max(temp2,temp1 - prices[i]);
        }

        return profit[0];
    }

    public static void main(String[] args){
        System.out.println(new LeetCode714().maxProfit(new int[]{1, 3, 2, 8, 4, 9},2));
    }
}
