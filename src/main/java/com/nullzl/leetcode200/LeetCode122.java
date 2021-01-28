package main.java.com.nullzl.leetcode200;

public class LeetCode122 {



    //ai,...aj,aj+1,an     ai <= ai+1 <=... aj   aj > aj+1     an > aj+1
    //an - ai < (aj-ai)+(an-aj+1)
    public int maxProfit(int[] prices) {

        int sum = 0;
        if(null == prices || 0 == prices.length)
            return sum;

        int start = prices[0];
        int preVal= prices[0];
        for(int i = 1; i < prices.length ; i++){
            if(prices[i] >= preVal){
                preVal = prices[i];
            }else{
                sum += (preVal - start);
                start = prices[i];
                preVal = prices[i];
            }
        }
        sum += (preVal - start);
        return sum;


    }
}
