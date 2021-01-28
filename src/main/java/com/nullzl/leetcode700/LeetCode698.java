package com.nullzl.leetcode700;

import java.util.Arrays;
import java.util.Random;

public class LeetCode698 {

    private boolean dfs(int state,int next,int[] nums,Boolean[] dp,int avg){
        if(null != dp[state])
            return dp[state];
        dp[state] = false;
        for(int i = 0 ,j = 1 ; i < nums.length && nums[i] <= next ; i++,j <<= 1){
            int left = next - nums[i];
            if(0 == (j & state) && dfs(state | j , 0 == left ? avg : left,nums,dp,avg)){
                dp[state] = true;
                break;
            }
        }
        return dp[state];
    }


    public boolean canPartitionKSubsets1(int[] nums, int k) {

        if(1 == k)
            return true;

        if(k == nums.length){
            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] != nums[i-1])
                    return false;
            }
            return true;
        }

        int total = Arrays.stream(nums).sum();
        if(0 != total % k)
            return false;

        int avg = total / k;
        Arrays.sort(nums);
        Boolean[] dp = new Boolean[1 << nums.length];
        dp[(1 << nums.length) - 1] = true;
        return dfs(0,avg,nums,dp,avg);
    }


    public boolean dfs2(int state,int next,int nextIdx,int[] nums,int avg){
        if((1 << nums.length) - 1 == state)
            return true;
        if(nextIdx < 0)
            return false;

        for(int i = nextIdx,j = (1 << nextIdx) ; i >= 0 ;){
            int left = next - nums[i];
            boolean tmp = (0 == (j & state)) && (left >= 0);
            if(tmp  && (0 == left ? dfs2((state | j) , avg,nums.length - 1,nums,avg) : dfs2((state | j),left,i - 1,nums,avg)))
                return true;
            do{
                i--;
                j >>= 1;
            }while(tmp && i >= 0 && nums[i] == nums[i-1]);
        }
        return false;

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        if(1 == k)
            return true;

        if(k == nums.length){
            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] != nums[i-1])
                    return false;
            }
            return true;
        }

        int total = Arrays.stream(nums).sum();
        if(0 != total % k)
            return false;

        int avg = total / k;
        Arrays.sort(nums);
        if(nums[nums.length - 1] > avg)
            return false;
        return dfs2(0,avg,nums.length - 1,nums,avg);

    }

    public static void main(String[] args){
        Random r = new Random();
        System.out.print("[" + (r.nextInt(8) + 1));
        for(int i= 1 ; i < 16 ; i++)
            System.out.print("," + (r.nextInt(8) + 1));
        System.out.print("]\r\n" + (r.nextInt(15) + 1));
    }
}
