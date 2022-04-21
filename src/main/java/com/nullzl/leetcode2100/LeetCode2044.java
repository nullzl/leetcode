package com.nullzl.leetcode2100;

import com.nullzl.util.Util;

public class LeetCode2044 {

    private int or(int set,int[] nums){
        int k = 1;
        int rs = 0;
        for(int i = 0 ; i < nums.length ; i++){
            rs |= (0 != (k & set) ? nums[i] : 0);
            k <<= 1;
        }
        return rs;
    }


    public int countMaxOrSubsets1(int[] nums) {
        int max = -1;
        int count = 0;
        for(int i = 1 ; i < (1 << nums.length) ; i++){
            int num = or(i,nums);
            if(num == max)
                count++;
            else if(num > max){
                max = num;
                count = 1;
            }
        }
        return count;
    }



    public static void main(String[] args){
        String s = Util.generateRandomArray(16,1,100000);
        System.out.println(s);
    }
}
