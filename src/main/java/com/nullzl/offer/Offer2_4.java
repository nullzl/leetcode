package com.nullzl.offer;

public class Offer2_4 {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for(int num : nums){
            int c = (~a & ~b & num) | (~a & b & ~num);
            int d = (~a & b & num) | (a & ~b & ~num) ;
            a = d;
            b = c;
        }
        return b;
    }
}
