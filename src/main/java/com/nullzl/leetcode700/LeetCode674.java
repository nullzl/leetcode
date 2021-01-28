package com.nullzl.leetcode700;

import java.util.Random;

public class LeetCode674 {

    public int findLengthOfLCIS(int[] nums) {

        if(null == nums || 0 == nums.length)
            return 0;

        int max = 1;
        int len = 1;
        for(int i = 1; i < nums.length ; i++){
            if(nums[i] > nums[i-1])
                len++;
            else {
                if(len > max)
                    max = len;
                len = 1;
            }
        }
        if(len > max)
            max = len;
        return max;
    }

    public static void  main(String[] args){
        Random r = new Random();
        int len = r.nextInt(10000) + 1;
        System.out.print("[" + r.nextInt());
        for(int i = 1 ; i < len ; i++){
            System.out.print("," + r.nextInt());
        }
        System.out.print("]");

    }
}
