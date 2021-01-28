package com.nullzl.leetcode700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class LeetCode673 {


    private void add(int[] sum , int i , int count){
        while(i < sum.length){
            sum[i] += count;
            i += (i & (-i));
        }
    }
    public int get(int[] sum,int i){
        int s = 0;
        while(0 != i){
            s += sum[i];
            i -= (i & (-i));
        }
        return  s;
    }

    public int findNumberOfLIS(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;
        if(1 == nums.length)
            return 1;

        int[] copy = new int[nums.length];
        System.arraycopy(nums,0,copy,0,nums.length);
        Arrays.sort(copy);
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = 1;
        map.put(copy[0],len++);
        for(int i = 1 ; i < copy.length ; i++){
            if(copy[i] != copy[i-1])
                map.put(copy[i],len++);
        }

        int[] dp = copy;
        Arrays.fill(dp,Integer.MAX_VALUE);
        int[][] counts = new int[nums.length][];
        int size = 0;


        for(int i = 0 ; i < nums.length ; i++){

            int idx = Arrays.binarySearch(dp,Math.max(0,size - 1 - nums.length + i),size,nums[i]);
            if(idx < 0)
                idx = -idx - 1;
            int count = 0;
            if(0 == idx){
                count = 1;
            }else{
                count = get(counts[idx-1],map.get(nums[i]) - 1);
            }
            if(idx == size) {
                counts[size++] = new int[len];
            }
            add(counts[idx],map.get(nums[i]),count);
            if(nums[i] < dp[idx])
                dp[idx] = nums[i];
        }
        return get(counts[size - 1],len - 1);
    }

    public static void main(String[] args){
//        System.out.println(new LeetCode673().findNumberOfLIS(new int[]{2,1}));
        Random r = new Random();
        int len = 2000;
        System.out.print("[" + (r.nextInt(20000000) - 40000000));
        for(int i = 1; i < len ; i++)
            System.out.print("," + (r.nextInt(20000000) - 10000000));
        System.out.print("]\r\n" );
    }
}
