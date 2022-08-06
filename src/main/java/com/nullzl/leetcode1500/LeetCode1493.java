package com.nullzl.leetcode1500;

import com.nullzl.util.Util;

public class LeetCode1493 {

    public int longestSubarray(int[] nums) {
        int max = 0;
        int sum = 0;
        int delSum = -1;
        for(int num : nums){
            if(0 == num){
                if(-1 != delSum)
                    max = Math.max(max,delSum + sum);
                delSum = sum;
                sum = 0;
            }else{
                sum++;
            }
        }
        if(-1 != delSum)
            return Math.max(max,delSum + sum);
        return nums.length - 1;
    }

    public static void main(String[] args){
        System.out.println(Util.generateRandomArray(10000,0,2));
    }
}
