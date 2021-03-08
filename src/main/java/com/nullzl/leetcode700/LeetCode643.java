package com.nullzl.leetcode700;

import java.util.Random;

public class LeetCode643 {

    public double findMaxAverage(int[] nums, int k) {

        if(null == nums || 0 == nums.length || 0 == k || k > nums.length)
            return 0;

        int i = 0 ;
        int j = 0 ;
        int sum = 0;
        int max;
        for( ; i < k ; i++)
            sum += nums[i];
        max = sum;
        for(; i < nums.length ; i++,j++){
            sum -= nums[j];
            sum += nums[i];
            if(sum > max)
                max = sum;
        }
        return ((double)sum) / k;

    }

    public static  void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(29000) + 1000;
        int k = r.nextInt(len) + 1;
        System.out.print("[" + (r.nextInt(20000) - 10000));
        for(int i = 1 ; i < len ; i++)
            System.out.print("," + (r.nextInt(20000) - 10000));
        System.out.println("]\r\n" + k);
    }
}
