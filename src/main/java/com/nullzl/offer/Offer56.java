package com.nullzl.offer;

public class Offer56 {

    public int[] singleNumbers(int[] nums) {

        int a = nums[0];
        for(int i = 1; i < nums.length ; i++)
            a ^= nums[i];

        int lowbit = a & (-a);
        int m = a;
        for(int i = 0 ; i < nums.length ; i++){
            if(0 != (lowbit & nums[i]))
                m ^= nums[i];
        }
        return new int[]{m,a ^ m};
    }

    public int singleNumber(int[] nums) {
        int a = 0 , b = 0;

        for(int i = 0 ; i < nums.length ; i++){
            int m = ((~a) & b & nums[i]) | (a & (~b) & (~nums[i]));
            int n = ((~a) & (~b) & nums[i]) | ((~a) & b & (~nums[i]));
            a = m;
            b = n;
        }
        return b;
    }
}
