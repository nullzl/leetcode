package com.nullzl.leetcode800;

import java.util.Random;

public class LeetCode713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(0 == k)
            return 0;
        int s = 0;
        int product = 1;
        int count = 0;
        for(int i = 0 ;i < nums.length ; i++){
            product *= nums[i];
            while(s <= i && product >= k){
                product /= nums[s++];
            }
            count += (i + 1 - s);
        }
        return count;
    }

    public static void main(String[] args){
        Random r = new Random();
        int len = r.nextInt(30000) + 1;
        System.out.print("[");
        for(int i = 0 ; i < len ; i++){
            System.out.print((r.nextInt(999) + 1) + ",");
        }
        System.out.println("]");
        System.out.println(r.nextInt(1000000));
    }
}
