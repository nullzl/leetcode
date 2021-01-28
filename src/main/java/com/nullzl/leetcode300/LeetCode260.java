package com.nullzl.leetcode300;

public class LeetCode260 {

    public int[] singleNumber(int[] nums) {

        int[] rs = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            rs[0] ^= nums[i];
        }
        rs[1] = rs[0];
        int x = rs[0] & (-rs[0]);
        for(int i = 0 ; i < nums.length ; i++){
            if(0 != (x & nums[i]))
                rs[1] ^= nums[i];
        }
        rs[0] = rs[0] ^ rs[1];
        return rs;
    }
}
