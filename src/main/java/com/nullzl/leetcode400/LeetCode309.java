package main.java.com.nullzl.leetcode400;

public class LeetCode309 {



    public int maxProfit(int[] prices) {
            if(null == prices || 0 == prices.length){
                return 0;
            }
            int[] profit = new int[3];
            profit[1] = -prices[0];
            int temp1,temp2,temp3;
            for(int i = 1 ; i < prices.length ;i++){
                temp1 = profit[0];
                temp2 = profit[1];
                temp3 = profit[2];

                profit[0] = Math.max(temp1,temp3);
                profit[1] = Math.max(temp2 , temp1-prices[i]);
                profit[2] = temp2 + prices[i];
            }
            return Math.max(profit[0],profit[2]);
    }

    public static void main(String[] args){
        System.out.println(new LeetCode309().maxProfit(new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6}));
    }
}
