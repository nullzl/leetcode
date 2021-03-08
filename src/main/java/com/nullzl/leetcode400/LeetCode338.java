package com.nullzl.leetcode400;

public class LeetCode338 {

    public int[] countBits(int num) {

        if(num < 0 )
            throw new IllegalArgumentException();

        int[] rs = new int[num + 1];
        rs[0] = 0;
        int i,len = num / 2 ;
        for(i = 0; i < len ; i++){
            rs[i << 1] = rs[i];
            rs[(i << 1) + 1] = rs[i] + 1;
        }
        if((i << 1) <= num)
            rs[i << 1] = rs[i];
        if((i << 1) + 1 <= num)
            rs[(i << 1) + 1] = rs[i] + 1;
        return rs;
    }
}
