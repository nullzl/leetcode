package com.nullzl.offer;

import java.util.Arrays;
import java.util.Random;

public class Offer2_104 {

    private void visit(int[] nums,int target,int[] dp,int sum){
        if(sum >= target)
            return ;
        dp[sum]++;
        for(int i = 0 ; i < nums.length && sum + nums[i] <= target ; i++){
            visit(nums,target,dp,sum + nums[i]);
        }
    }

    public int combinationSum4_1(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        visit(nums,target,dp,0);
        return dp[target];
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0]= 1;
        for(int i = 1 ;i <= target ; i++){
            for(int j = 0 ; j < nums.length && nums[j] <= i ; j++){
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(50) + 50;
        int[] map = new int[1001];
        System.out.print("[");
        for(int i = 0 ;i < len ; ){
            int n = r.nextInt(1000) + 1;
            if(0 == map[n]){
                map[n] = 1;
                System.out.print(n + ",");
                i++;
            }
        }
        System.out.print("]" + "\n" + (r.nextInt(1000) + 1));
    }
}
