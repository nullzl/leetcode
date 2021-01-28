package main.java.com.nullzl.leetcode400;

public class LeetCode312 {




    public int maxCoins(int[] nums) {

        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] coins = new int[nums.length + 2];
        System.arraycopy(nums,0,coins,1,nums.length);
        coins[0] = 1;
        coins[nums.length + 1] = 1;

        for(int i = nums.length - 1 ; i >= 0 ; i--){
            for(int j = i + 2 ; j < nums.length + 2 ; j++){
                int val = 0 ;
                for(int k = i + 1; k <= j - 1; k++){
                    val = Math.max(val,
                            dp[i][k] + dp[k][j] + coins[i] * coins[k] * coins[j]);
                }
                dp[i][j] = val;

            }
        }

        return dp[0][nums.length + 1];
    }

    public static void main(String[] args){
        System.out.print(new LeetCode312().maxCoins(
                new int[]{3}
        ));
    }
}
